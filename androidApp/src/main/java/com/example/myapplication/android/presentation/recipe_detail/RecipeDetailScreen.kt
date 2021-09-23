package com.example.myapplication.android.presentation.recipe_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.example.myapplication.android.presentation.components.RecipeImage
import com.example.myapplication.android.presentation.recipe_list.components.RecipeCard
import com.example.myapplication.android.presentation.theme.AppTheme
import com.example.myapplication.domain.model.Recipe

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun RecipeDetailScreen(
    recipe: Recipe?,
) {
    AppTheme(displayProgressBar = false) {
        if (recipe == null) {
            Text("Unable to get the details of this recipe...")
        } else {
            Column {
                RecipeCard(
                    recipe = recipe,
                    onClick = {}
                )
            }
        }
    }

}