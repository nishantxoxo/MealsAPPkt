package com.example.mealapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel :ViewModel() {
    private val _categoryState = mutableStateOf(RecipeState())
    val categoiesSate : State<RecipeState> = _categoryState

    private fun fetchCategories(){
        viewModelScope.launch {
            try {
                val response = recipeService.getCategories()
                _categoryState.value = _categoryState.value.copy(list = response.cats,
                    loading = false,
                    error = null
                    )

            }
            catch (e : Exception){
                 _categoryState.value = _categoryState.value.copy(
                     loading = false,
                     error = "Error in fetchcing categories  ${e.message}"
                 )
            }
        }
    }


    data class RecipeState(
        val loading: Boolean = true,
        val list: List<category> = emptyList(),
        val error: String? = null
    )
}