package com.example.myapplication.datasource.cache

import com.example.myapplication.domain.model.Recipe
import com.example.myapplication.domain.util.DateTimeUtil
import com.squareup.sqldelight.db.SqlDriver

class RecipeDatabaseFactory(private val driverFactory: DriverFactory) {
    fun createDatabase(): RecipeDatabase {
        return RecipeDatabase(driverFactory.createDriver())
    }
}

expect class DriverFactory {
    fun createDriver(): SqlDriver
}

fun Recipe_Entity.toRecipe():Recipe {
    val dateTimeUtil: DateTimeUtil = DateTimeUtil()

    return Recipe(
        id = id.toInt(),
        title = title,
        publisher = publisher,
        featuredImage = featured_image,
        rating = rating.toInt(),
        sourceUrl = source_url,
        ingredients = ingredients.convertIngredientsStringToList(),
        dateUpdated = dateTimeUtil.toLocalDate(date_updated),
        dateAdded = dateTimeUtil.toLocalDate(date_added)
    )
}

fun List<Recipe_Entity>.toRecipeList():List<Recipe>{
    return map { it.toRecipe() }
}

//Convert list of string to comma separate string
fun List<String>.convertIngredientListToString():String {
    val ingredientsString = StringBuilder()
    for(ingredient in this){
        ingredientsString.append("$ingredient,")
    }
    return ingredientsString.toString()
}

fun String.convertIngredientsStringToList(): List<String>{
    val list:ArrayList<String> = ArrayList()
    for(ingredient in split(",")){
        list.add(ingredient)
    }
    return list
}
