package com.example.drinkapp.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.drinkapp.model.DbModel
import com.example.drinkapp.model.DrinkModel
import com.example.drinkapp.view.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CachViewModel : ViewModel() {
    fun insert(noteModel: DbModel, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.insertDrink(noteModel) {
                onSuccess
            }
        }

    fun insertDrink(noteModel: DrinkModel, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.insertDrinkString(noteModel) {
                onSuccess
            }
        }

    fun delete(onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.deleteDrink() {
                onSuccess
            }
        }

    fun deleteDrink(onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.deleteDrinkString() {
                onSuccess
            }
        }
}