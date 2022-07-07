package com.example.drinkapp.Repository

import androidx.lifecycle.LiveData
import com.example.drinkapp.dao.DrinkDao
import com.example.drinkapp.model.DbModel
import com.example.drinkapp.model.DrinkModel

interface RepositoryDrink {
    val allDB: LiveData<List<DbModel>>
    val allDrink: LiveData<List<DrinkModel>>
    suspend fun insertDrink(noteModel: DbModel, onSuccess:()-> Unit)
    suspend fun insertDrinkString(noteModel: DrinkModel, onSuccess:()-> Unit)
    suspend fun deleteDrink( onSuccess:()-> Unit)
    suspend fun deleteDrinkString( onSuccess:()-> Unit)
    suspend fun filterDrink(filter:String): LiveData<List<DrinkModel>>

}
