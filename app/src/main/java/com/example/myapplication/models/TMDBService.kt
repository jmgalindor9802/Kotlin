package com.example.myapplication.models

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {//Configuracion Retrofit
    @GET("movie/popular") //Endpoint
    fun listPopularPelis(@Query("api_key") apiKey:String): Call<resumenPelis>
}