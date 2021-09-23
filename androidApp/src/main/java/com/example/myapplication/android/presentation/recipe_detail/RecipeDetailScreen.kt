package com.example.myapplication.android.presentation.recipe_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.myapplication.domain.model.Recipe

@Composable
fun RecipeDetailScreen(
    recipe: Recipe?,
){
    if(recipe == null){
        Text("Unable to get the details of this recipe...")
    }
    else{
        Column{
            Text(recipe.title)
        }
    }
}