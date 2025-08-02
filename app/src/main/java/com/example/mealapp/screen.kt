package com.example.mealapp

sealed class screen(val route:String) {
    object RecipeScreen:screen("recipescreen");
    object DetailScreen:screen("detailscreen");

}