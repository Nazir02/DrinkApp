package com.example.drinkapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "cache")
data class DbModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int =0,
    @ColumnInfo
    val strDrink: String,
    )
