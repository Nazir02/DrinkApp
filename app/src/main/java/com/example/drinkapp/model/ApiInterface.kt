package com.example.drinkapp.model

import com.example.drinkapp.db.categories.categories
import com.example.drinkapp.db.details.detail
import com.example.drinkapp.db.drinksCoctel.Cocktail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("list.php?c=list")
    suspend fun getCategory() : Response<categories>
    @GET("filter.php?")
    suspend fun getCoctel(@Query("c") category:String) : Response<Cocktail>
    @GET("lookup.php?")
    suspend fun getDetail(@Query("i") i:String) : Response<detail>
    @GET("search.php?")
    suspend fun getSearch(@Query("s") s:String) : Response<Cocktail>
}