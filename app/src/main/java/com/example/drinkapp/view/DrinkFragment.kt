package com.example.drinkapp.view

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.drinkapp.MainActivity
import com.example.drinkapp.R
import com.example.drinkapp.adapter.RV_Adapter
import com.example.drinkapp.model.ApiClient
import com.example.drinkapp.model.ApiInterface
import com.example.drinkapp.model.DrinkModel
import com.example.drinkapp.vm.CachViewModel
import com.example.drinkapp.vm.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

const val ARG = "object"
class DrinkFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_drink, container, false)
         recyclerView= view.findViewById(R.id.rv_drink)
        val quotesApi = ApiClient.getInstance().create(ApiInterface::class.java)



        CoroutineScope(Dispatchers.Main).launch {
            if (isConnected(requireContext()) == true) {
                val viewModel = ViewModelProvider(requireActivity()).get(CachViewModel::class.java)
                viewModel.deleteDrink() {}
                val result = quotesApi.getCoctel(arguments?.get(ARG).toString()).body()!!
                for (i in result.drinks) {
                    viewModel.insertDrink(
                        DrinkModel(
                            drinkString = i.strDrink,
                            drinkCategories = arguments?.get(ARG).toString(),
                            strDrinkThumb = i.strDrinkThumb
                        )
                    ) {}
                }
            }
            val viewModelMain=ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
            viewModelMain.getItemFilter(arguments?.get(ARG).toString()).observe(viewLifecycleOwner){
                recyclerView.adapter = RV_Adapter(it)
            }





        }
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