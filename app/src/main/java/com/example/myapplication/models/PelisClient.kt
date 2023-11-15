package com.example.myapplication.models

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PelisClient {
    private val retrofit= Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(TMDBService::class.java)
}