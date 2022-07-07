package com.example.drinkapp.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.drinkapp.Repository.RealizationDrink
import com.example.drinkapp.db.drinkDb.DrinkDatabase
import com.example.drinkapp.model.DbModel
import com.example.drinkapp.model.DrinkModel
import com.example.drinkapp.view.REPOSITORY

class MainViewModel(application: Application):AndroidViewModel(application) {
    val context=application
    fun initDatabase(){
        val daoNote=DrinkDatabase.getInstance(context).getDrinkDao()
        REPOSITORY=RealizationDrink(daoNote)
    }

    fun getallDB(): LiveData<List<DbModel>> {
        return REPOSITORY.allDB
    }
    fun getallDrink(): LiveData<List<DrinkModel>> {
        return REPOSITORY.allDrink
    }
    suspend fun getItemFilter(filter:String):LiveData<List<DrinkModel>>{
         return REPOSITORY.filterDrink(filter)

    }
}