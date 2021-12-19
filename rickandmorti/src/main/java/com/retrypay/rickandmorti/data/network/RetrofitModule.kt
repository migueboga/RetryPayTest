package com.retrypay.rickandmorti.data.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.retrypay.rickandmorti.BuildConfig
import com.retrypay.rickandmorti.data.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitModule {

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}