package com.example.mealapp

data class category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String
) {

}


data class CategoriesRes(val cats: List<category>)

