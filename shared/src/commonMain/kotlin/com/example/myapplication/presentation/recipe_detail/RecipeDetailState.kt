package com.example.myapplication.presentation.recipe_detail

import com.example.myapplication.domain.model.Recipe

data class RecipeDetailState(
    val isLoading: Boolean = false,
    val recipe: Recipe? = null
)
