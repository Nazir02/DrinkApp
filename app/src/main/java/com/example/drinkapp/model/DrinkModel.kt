package com.example.drinkapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "drink")
data class DrinkModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo
    var drinkCategories: String,
    @ColumnInfo
    var drinkString: String,
    @ColumnInfo
    val strDrinkThumb: String

)
