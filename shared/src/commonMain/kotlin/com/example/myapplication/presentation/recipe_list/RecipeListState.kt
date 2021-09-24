package com.example.myapplication.presentation.recipe_list

import com.example.myapplication.domain.model.Recipe

data class RecipeListState(
    val isLoading: Boolean = false,
    val page: Int = 1,
    val query: String = "",
    val selectedCategory: FoodCategory? = null,
    val recipes: List<Recipe> = listOf()
) {
    //Create a constructor filling default vals to allow Swift use this class
    constructor() : this(
        isLoading = false,
        page = 1,
        query = "",
        selectedCategory = null,
        recipes = listOf()
    )

}