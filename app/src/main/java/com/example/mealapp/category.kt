package com.example.mealapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String
): Parcelable

data class CategoriesRes(val cats: List<category>)

