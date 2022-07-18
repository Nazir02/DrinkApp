package com.example.drinkapp.view

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.SearchView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.drinkapp.MainActivity
import com.example.drinkapp.R
import com.example.drinkapp.adapter.RV_Adapter
import com.example.drinkapp.vm.MainVMRetrofit
import org.koin.androidx.viewmodel.ext.android.viewModel

const val ARG = "object"
class DrinkFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    private val viewModelRetrofit: MainVMRetrofit by viewModel()

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_drink, container, false)
         recyclerView= view.findViewById(R.id.rv_drink)
        viewModelRetrofit.drinkS.observe(requireActivity(), Observer {
            it.let { recyclerView.adapter = RV_Adapter(it) }})
        viewModelRetrofit.fetchDrink(arguments?.get(ARG).toString())

//        val quotesApi = ApiClient.getInstance().create(ApiInterface::class.java)
//        CoroutineScope(Dispatchers.Main).launch {
//            val activity = context
//
//            if (activity?.let { isOnline(it) } == true) {
//                val viewModel = ViewModelProvider(requireActivity()).get(CachViewModel::class.java)
//                val result = quotesApi.getCoctel(arguments?.get(ARG).toString()).body()!!
//                for (i in result.drinks) {
//                    viewModel.insertDrink(
//                        DrinkModel(
//                            idD=i.idDrink,
//                            drinkString = i.strDrink,
//                            drinkCategories = arguments?.get(ARG).toString(),
//                            strDrinkThumb = i.strDrinkThumb
//                        )
//                    ) {}
//                }
//            }
//            val viewModelMain=ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
//            viewModelMain.getItemFilter(arguments?.get(ARG).toString()).observe(viewLifecycleOwner){
//                recyclerView.adapter = RV_Adapter(it)
//            }
//        }
        setHasOptionsMenu(true)
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
        inflater.inflate(R.menu.search_item, menu)
        val searchView =
            SearchView((context as MainActivity).supportActionBar?.themedContext ?: context)
        menu.findItem(R.id.search).apply {
            actionView = searchView
        }
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String): Boolean {
//                val quotesApi = ApiClient.getInstance().create(ApiInterface::class.java)
//                CoroutineScope(Dispatchers.Main).launch {
//                    val a=  RV_Adapter(quotesApi.getSearch(query).body()!!)
//                    if (quotesApi.getSearch(query).body() !=null){
//                  recyclerView.adapter=a}
//
//                }
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String): Boolean {
//                val quotesApi = ApiClient.getInstance().create(ApiInterface::class.java)
//                CoroutineScope(Dispatchers.Main).launch {
//                        recyclerView.adapter=RV_Adapter(quotesApi.getSearch(newText).body()!!)
//                }
//                return false
//            }
//        })

    }
}