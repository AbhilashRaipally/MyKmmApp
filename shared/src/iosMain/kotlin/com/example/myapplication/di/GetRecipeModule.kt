package com.example.myapplication.di

import com.example.myapplication.interactors.recipe_detail.GetRecipe

class GetRecipeModule(
    private val cacheModule: CacheModule
) {
    val getRecipe: GetRecipe by lazy {
        GetRecipe(
            recipeCache = cacheModule.recipeCache
        )
    }
}