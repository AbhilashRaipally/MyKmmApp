package com.example.myapplication.datasource.network

import com.example.myapplication.domain.model.Recipe

interface RecipeService {
    suspend fun search(page:Int, query:String):List<Recipe>
    suspend fun get(id:Int):Recipe
}