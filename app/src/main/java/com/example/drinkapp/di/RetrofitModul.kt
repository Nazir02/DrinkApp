package com.example.drinkapp.di

import com.example.drinkapp.api.ApiHelper
import com.example.drinkapp.api.ApiHelperImpl
import com.example.drinkapp.api.ApiInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

var retrofitModule= module {
    single { ApiClient.getInstance() }
    single {provideApiService(get()) }
    single<ApiHelper> {
        return@single ApiHelperImpl(get())
    }
}

object ApiClient {
    private const  val BASE_URL="https://www.thecocktaildb.com/api/json/v1/1/"
    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
    private val okHttpClient = OkHttpClient().newBuilder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build() }
private fun provideApiService(retrofit: Retrofit): ApiInterface =
    retrofit.create(ApiInterface::class.java)