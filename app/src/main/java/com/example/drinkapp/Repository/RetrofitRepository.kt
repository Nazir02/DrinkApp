package com.example.drinkapp.Repository

import com.example.drinkapp.api.ApiHelper

class RetrofitRepository(private val apiHelper: ApiHelper) {
    suspend fun getUsers() =  apiHelper.getCategory()
    suspend fun getCoctel(drink:String) =  apiHelper.getCoctel(drink)

}