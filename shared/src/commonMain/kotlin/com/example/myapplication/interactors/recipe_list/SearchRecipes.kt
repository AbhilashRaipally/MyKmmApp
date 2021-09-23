package com.example.myapplication.interactors.recipe_list

import com.example.myapplication.datasource.cache.RecipeCache
import com.example.myapplication.datasource.network.RecipeService
import com.example.myapplication.domain.model.Recipe
import com.example.myapplication.domain.util.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRecipes(
    private val recipeService: RecipeService,
    private val recipeCache: RecipeCache
) {
    fun execute(page:Int, query:String):Flow<DataState<List<Recipe>>> = flow {
        //Loading
        emit(DataState.loading())

        //Network call and update cache
        try{
            //network call
            val recipes = recipeService.search(page,query)

            delay(500)

            //DB insert
            recipeCache.insert(recipes)

            val cacheResult = if(query.isBlank()){
                recipeCache.getAll(page)
            }else{
                recipeCache.search(query, page)
            }

            emit(DataState.data(data = cacheResult))
        }catch (e:Exception){
            //Error
            emit(DataState.error(message = e.message?:"Unknown error"))
        }
    }

}