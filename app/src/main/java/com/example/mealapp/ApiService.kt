package com.example.mealapp

import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.converter.gson.GsonConverterFactory


private  val retrofit = Retrofit.Builder().baseUrl("www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create()).build()

interface ApiService {
    @GET("categories.php")
    suspend fun getCategories():CategoriesRes

}