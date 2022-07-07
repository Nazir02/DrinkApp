package com.example.drinkapp.db.drinkDb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.drinkapp.dao.DrinkDao
import com.example.drinkapp.model.DbModel
import com.example.drinkapp.model.DrinkModel

@Database(entities = [DbModel::class,DrinkModel::class], version = 1)
abstract class DrinkDatabase : RoomDatabase() {

    abstract fun getDrinkDao(): DrinkDao

    companion object {

        private var database:DrinkDatabase ?= null

        @Synchronized
        fun getInstance(context: Context): DrinkDatabase {
            return if (database == null) {
                database = Room.databaseBuilder(context, DrinkDatabase::class.java, "db5")
                    .fallbackToDestructiveMigration().allowMainThreadQueries().build()
                database as DrinkDatabase
            }else
                database as DrinkDatabase
        }

//        @Synchronized
//        fun getInstanceDrink(context: Context): DrinkDatabase {
//            return if (databaseDrink == null) {
//                databaseDrink = Room.databaseBuilder(context, DrinkDatabase::class.java, "db1")
//                    .fallbackToDestructiveMigration().allowMainThreadQueries().build()
//                databaseDrink as DrinkDatabase
//            }else
//                databaseDrink as DrinkDatabase
//        }

    }

}