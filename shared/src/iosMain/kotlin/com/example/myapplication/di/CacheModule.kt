package com.example.myapplication.di

import com.example.myapplication.datasource.cache.*
import com.example.myapplication.domain.util.DateTimeUtil

class CacheModule {
    private val driverFactory: DriverFactory by lazy { DriverFactory() }
    val recipeDatabase: RecipeDatabase by lazy {
        RecipeDatabaseFactory(driverFactory = driverFactory).createDatabase()
    }

    val recipeCache: RecipeCache by lazy {
        RecipeCacheImpl(
            recipeDatabase = recipeDatabase,
            dateTimeUtil = DateTimeUtil(),
        )
    }
}