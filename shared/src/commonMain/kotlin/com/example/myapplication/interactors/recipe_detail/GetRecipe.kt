package com.example.myapplication.interactors.recipe_detail

import com.example.myapplication.datasource.cache.RecipeCache
import com.example.myapplication.domain.model.Recipe
import com.example.myapplication.domain.util.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetRecipe(private val recipeCache: RecipeCache) {
    fun execute(recipeId:Int): Flow<DataState<Recipe>> = flow {
        //Loading
        emit(DataState.loading())

        //Network call
        try {
            delay(1000)
            val recipe = recipeCache.get(recipeId)
            emit(DataState.data(data = recipe))
        }catch (e:Exception){
            //Error
            emit(DataState.error(message = e.message?:"Cache error"))
        }
    }
}