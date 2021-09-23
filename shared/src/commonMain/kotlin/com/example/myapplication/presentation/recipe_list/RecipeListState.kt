package com.example.myapplication.presentation.recipe_list

import com.example.myapplication.domain.model.Recipe

data class RecipeListState(
    val isLoading: Boolean = false,
    val page: Int = 1,
    val query: String = "",
    val recipes: List<Recipe> = listOf()
) {

}