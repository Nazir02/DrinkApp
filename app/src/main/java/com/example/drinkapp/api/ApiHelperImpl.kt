package com.example.drinkapp.api

import com.example.drinkapp.models.categories.categories
import com.example.drinkapp.models.drinksCoctel.Cocktail
import retrofit2.Response

class ApiHelperImpl(private val apiService: ApiInterface) : ApiHelper {

    override suspend fun getCategory(): Response<categories> {
        return apiService.getCategory()
    }

    override suspend fun getCoctel(category: String): Response<Cocktail> {
        return apiService.getCoctel(category)
    }


}