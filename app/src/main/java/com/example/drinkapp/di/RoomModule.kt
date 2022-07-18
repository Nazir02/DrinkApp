package com.example.drinkapp.di

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.drinkapp.dao.DrinkDao
import com.example.drinkapp.model_Room.DbModel
import com.example.drinkapp.model_Room.DrinkModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module


@Database(entities = [DbModel::class, DrinkModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): DrinkDao
}
val dataModule: Module = module {
    single {
        Room.databaseBuilder(androidContext(),
            AppDatabase::class.java, "app-database").build()
    }
    single { get<AppDatabase>().userDao() }

}
