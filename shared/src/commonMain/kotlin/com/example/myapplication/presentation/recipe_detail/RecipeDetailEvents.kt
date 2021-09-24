package com.example.myapplication.presentation.recipe_detail

sealed class RecipeDetailEvents {
    data class GetRecipe(val recipeId: Int): RecipeDetailEvents()
}
