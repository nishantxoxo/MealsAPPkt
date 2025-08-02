package com.example.mealapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navController: NavHostController){
    val recipeviewmodel: MainViewModel = viewModel()

    val viewstate by recipeviewmodel.categoiesSate

    NavHost(navController = navController, startDestination = screen.RecipeScreen.route){
        composable(route = screen.RecipeScreen.route ){
            RecipeScreen(viewstate = viewstate ,navigateToDetail = {
                navController.currentBackStackEntry?.savedStateHandle?.set("cat", it)
                navController.navigate(screen.DetailScreen.route)
            })
        }
        composable(route = screen.DetailScreen.route){
            val category = navController.previousBackStackEntry?.savedStateHandle?.get<category>("cat") ?: category("", "", "", "")

            categoryDetailScreen(category)
        }
    }
}