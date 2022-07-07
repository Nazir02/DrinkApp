package com.example.drinkapp.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.drinkapp.model.DbModel
import com.example.drinkapp.model.DrinkModel

@Dao
interface DrinkDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(drinkModel: DbModel)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertDrink(drinkModel: DrinkModel)

    @Query("delete  FROM cache")
    suspend fun delete()

    @Query("delete  FROM drink")
    suspend fun deleteDrink()

    @Query("SELECT * from cache")
    fun getAllNotes(): LiveData<List<DbModel>>

    @Query("SELECT * from drink")
    fun getAllDrink(): LiveData<List<DrinkModel>>

    @Query("SELECT * from drink WHERE drinkCategories = :filter")
     fun getItemsFiltered(filter: String): LiveData<List<DrinkModel>>
}