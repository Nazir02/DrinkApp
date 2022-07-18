package com.example.drinkapp.di

import com.example.drinkapp.vm.MainVMRetrofit
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var viewModelModule= module {
        viewModel {
            MainVMRetrofit(get())
        }
    }
