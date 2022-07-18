package com.example.drinkapp.Repository

import androidx.lifecycle.LiveData
import com.example.drinkapp.dao.DrinkDao
import com.example.drinkapp.model_Room.DbModel
import com.example.drinkapp.model_Room.DrinkModel

class RealizationDrink(private val DaoDrink: DrinkDao) : RepositoryDrink {
    override val allDB: LiveData<List<DbModel>> get() = DaoDrink.getAllNotes()
    override val allDrink: LiveData<List<DrinkModel>> get() = DaoDrink.getAllDrink()

    override suspend fun insertDrink(noteModel: DbModel, onSuccess: () -> Unit) {
        DaoDrink.insert(noteModel)
        onSuccess
    }

    override suspend fun insertDrinkString(noteModel: DrinkModel, onSuccess: () -> Unit) {
        DaoDrink.insertDrink(noteModel)
        onSuccess
    }

    override suspend fun deleteDrink(onSuccess: () -> Unit) {
        DaoDrink.delete()
        onSuccess
    }

    override suspend fun deleteDrinkString(onSuccess: () -> Unit) {
        DaoDrink.deleteDrink()
        onSuccess    }

    override suspend fun filterDrink(filter: String): LiveData<List<DrinkModel>> {
      return  DaoDrink.getItemsFiltered(filter)
    }

}