package com.example.drinkapp.model_Room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cache")
data class DbModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int =0,
    @ColumnInfo
    val strDrink: String,
    )
