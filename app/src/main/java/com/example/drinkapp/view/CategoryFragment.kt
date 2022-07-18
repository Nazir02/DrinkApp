package com.example.drinkapp.view

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.drinkapp.R
import com.example.drinkapp.adapter.DrinkAdapter
import com.example.drinkapp.vm.MainVMRetrofit
import com.example.drinkapp.vm.MainViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel


class CategoryFragment : Fragment() {
    lateinit var viewPAger: ViewPager2
    lateinit var tabLayout: TabLayout
    private val mainVM_R: MainVMRetrofit by viewModel()

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_category, container, false)
        setHasOptionsMenu(true)
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
            viewModel.initDatabase()

        viewPAger = view.findViewById(R.id.viewPager2)
        tabLayout = view.findViewById(R.id.mainTablayout)
//        val quotesApi = ApiClient.getInstance().create(ApiInterface::class.java)
        mainVM_R.drinks_T.observe(requireActivity(), Observer {
            it?.let { drinks_T ->
                viewPAger.adapter = DrinkAdapter(context as FragmentActivity, it ) }
            TabLayoutMediator(tabLayout, viewPAger) { tab, posiion ->
                tab.text = it[posiion].strCategory
            }.attach()
        })


//        CoroutineScope(Dispatchers.Main).launch {
//            if (isOnline(requireContext())) {
//                val viewModel = ViewModelProvider(requireActivity()).get(CachViewModel::class.java)
//                viewModel.delete() {}
//                viewModel.deleteDrink() {}
//               val  result = quotesApi.getCategory().body()!!
//                for (model in result.drinks) {
//                    viewModel.insert(
//                        DbModel(
//                            strDrink = model.strCategory
//                        )
//                    ) {}
//                }
//            }
//                viewModel.getallDB().observe(viewLifecycleOwner){
//                    viewPAger.adapter = DrinkAdapter(context as FragmentActivity, it )
//
//            }
//
//
//
//        }
        return view
    }

}