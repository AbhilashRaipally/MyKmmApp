package com.example.myapplication.datasource.network

import com.example.myapplication.datasource.network.model.RecipeDto
import com.example.myapplication.domain.model.Recipe
import com.example.myapplication.domain.util.DateTimeUtil
import io.ktor.client.*

expect class KtorClientFactory(){
    fun build(): HttpClient
}

fun RecipeDto.toRecipe(): Recipe{
    val dateTimeUtil = DateTimeUtil()
    return Recipe(
        id = pk,
        title = title,
        rating = rating,
        featuredImage = featuredImage,
        publisher = publisher,
        sourceUrl = sourceUrl,
        ingredients = ingredients,
        dateAdded = dateTimeUtil.toLocalDate(longDateAdded.toDouble()),
        dateUpdated = dateTimeUtil.toLocalDate(longDateUpdated.toDouble())
    )
}

fun List<RecipeDto>.toRecipeList(): List<Recipe>{
    return map { it.toRecipe() }
}