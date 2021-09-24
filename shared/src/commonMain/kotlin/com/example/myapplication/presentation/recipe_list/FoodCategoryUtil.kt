package com.example.myapplication.presentation.recipe_list

class FoodCategoryUtil {
    fun getAllFoodCategories(): List<FoodCategory>{
        return listOf(
            FoodCategory.VEGAN,
            FoodCategory.VEGETARIAN,
            FoodCategory.DESSERT,
            FoodCategory.SOUP,
            FoodCategory.PIZZA,
            FoodCategory.CHICKEN,
            FoodCategory.ERROR
        )
    }

    fun getFoodCategory(value: String): FoodCategory?{
        return FoodCategory.values().associateBy(FoodCategory::value)[value]
    }
}