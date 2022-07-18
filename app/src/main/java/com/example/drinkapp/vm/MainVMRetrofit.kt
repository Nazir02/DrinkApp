package com.example.drinkapp.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.drinkapp.Repository.RetrofitRepository
import com.example.drinkapp.models.categories.DrinkX
import com.example.drinkapp.models.drinksCoctel.DrinkCoctel
import kotlinx.coroutines.launch

class MainVMRetrofit(
    private val mainRepository: RetrofitRepository,
) : ViewModel() {
    private val drinksT = MutableLiveData<List<DrinkX>>()
    val drinks_T: LiveData<List<DrinkX>>
        get() = drinksT

    private val drinks = MutableLiveData<List<DrinkCoctel>>()
    val drinkS: LiveData<List<DrinkCoctel>>
        get() = drinks
    init {
        fetchDrink("Ordinary Drink")
    }

     fun fetchDrink(string: String) {
        viewModelScope.launch {
            mainRepository.getUsers().let {
                drinksT.postValue(it.body()?.drinks)
            }
            mainRepository.getCoctel(string).let {
                drinks.postValue(it.body()?.drinks)
            }
        }
    }
}


