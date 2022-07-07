package com.example.drinkapp.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.drinkapp.R
import com.example.drinkapp.adapter.DrinkAdapter
import com.example.drinkapp.model.ApiClient
import com.example.drinkapp.model.ApiInterface
import com.example.drinkapp.model.DbModel
import com.example.drinkapp.vm.CachViewModel
import com.example.drinkapp.vm.MainViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CategoryFragment : Fragment() {
    lateinit var viewPAger: ViewPager2
    lateinit var tabLayout: TabLayout

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
        val quotesApi = ApiClient.getInstance().create(ApiInterface::class.java)

        CoroutineScope(Dispatchers.Main).launch {
            if (isConnected(requireContext()) == true) {
                val viewModel = ViewModelProvider(requireActivity()).get(CachViewModel::class.java)
                viewModel.delete() {}
               val  result = quotesApi.getCategory().body()!!
                for (model in result.drinks) {
                    viewModel.insert(
                        DbModel(
                            strDrink = model.strCategory
                        )
                    ) {}
                }
            }
                viewModel.getallDB().observe(viewLifecycleOwner){
                    viewPAger.adapter = DrinkAdapter(context as FragmentActivity, it )
                    TabLayoutMediator(tabLayout, viewPAger) { tab, posiion ->
                        tab.text = it[posiion].strDrink
                    }.attach()
            }



        }
        return view
    }
}