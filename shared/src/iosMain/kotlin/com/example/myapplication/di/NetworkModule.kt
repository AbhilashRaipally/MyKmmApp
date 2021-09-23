package com.example.myapplication.di

import com.example.myapplication.datasource.network.KtorClientFactory
import com.example.myapplication.datasource.network.RecipeService
import com.example.myapplication.datasource.network.RecipeServiceImpl

class NetworkModule {
    val recipeService: RecipeService by lazy {
        RecipeServiceImpl(
            httpClient = KtorClientFactory().build(),
            baseUrl = RecipeServiceImpl.BASE_URL
        )
    }
}