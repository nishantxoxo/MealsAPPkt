package com.example.mealapp

import retrofit2.http.GET

interface ApiService {
    @GET("categories.php")
    suspend fun getCategories():CategoriesRes

}