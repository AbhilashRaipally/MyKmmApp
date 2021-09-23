package com.example.myapplication.android.di

import com.example.myapplication.datasource.network.RecipeService
import com.example.myapplication.interactors.recipe_detail.GetRecipe
import com.example.myapplication.interactors.recipe_list.SearchRecipes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InteractorsModule {
    @Singleton
    @Provides
    fun provideSearchRecipes(
        recipeService: RecipeService
    ):SearchRecipes{
        return SearchRecipes(recipeService = recipeService)
    }

    @Singleton
    @Provides
    fun providesGetRecipe(
        recipeService: RecipeService
    ):GetRecipe{
        return GetRecipe(recipeService = recipeService)
    }
}