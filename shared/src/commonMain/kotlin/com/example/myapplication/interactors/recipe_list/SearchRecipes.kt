package com.example.myapplication.interactors.recipe_list

import com.example.myapplication.datasource.network.RecipeService
import com.example.myapplication.domain.model.Recipe
import com.example.myapplication.domain.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRecipes(
    private val recipeService: RecipeService
) {
    fun execute(page:Int, query:String):Flow<DataState<List<Recipe>>> = flow {
        //Loading
        emit(DataState.loading())

        //Network call
        try{
            val recipes = recipeService.search(page,query)
            emit(DataState.data(data = recipes))
        }catch (e:Exception){
            //Error
            emit(DataState.error(message = e.message?:"Unknown error"))
        }
    }

}