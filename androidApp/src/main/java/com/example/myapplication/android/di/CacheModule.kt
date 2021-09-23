package com.example.myapplication.android.di

import com.example.myapplication.android.BaseApplication
import com.example.myapplication.datasource.cache.*
import com.example.myapplication.domain.util.DateTimeUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {
    @Singleton
    @Provides
    fun provideRecipeDatabase(context: BaseApplication): RecipeDatabase {
        return RecipeDatabaseFactory(driverFactory = DriverFactory(context = context)).createDatabase()
    }

    @Singleton
    @Provides
    fun provideRecipeCache(recipeDatabase: RecipeDatabase): RecipeCache {
        return RecipeCacheImpl(recipeDatabase = recipeDatabase, dateTimeUtil = DateTimeUtil())
    }
}