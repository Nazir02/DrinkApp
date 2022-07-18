package com.example.drinkapp

import android.app.Application
import com.example.drinkapp.di.repoModule
import com.example.drinkapp.di.retrofitModule
import com.example.drinkapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@BaseApplication)
            androidFileProperties()
            modules(listOf( retrofitModule,repoModule,viewModelModule))
        }
    }
} 