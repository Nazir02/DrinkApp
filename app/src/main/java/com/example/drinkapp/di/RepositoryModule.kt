package com.example.drinkapp.di

import com.example.drinkapp.Repository.RetrofitRepository
import org.koin.dsl.module

var repoModule= module {
    single { RetrofitRepository(get()) }
}