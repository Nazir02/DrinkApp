package com.example.drinkapp.api

import com.example.drinkapp.models.categories.categories
import com.example.drinkapp.models.drinksCoctel.Cocktail
import retrofit2.Response
import retrofit2.http.Query

interface ApiHelper {
    suspend fun getCategory() : Response<categories>
    suspend fun getCoctel(@Query("c") category:String) : Response<Cocktail>

}