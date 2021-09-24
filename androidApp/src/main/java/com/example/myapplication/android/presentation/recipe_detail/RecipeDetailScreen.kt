package com.example.myapplication.android.presentation.recipe_detail

import android.hardware.TriggerEvent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.android.presentation.components.RECIPE_IMAGE_HEIGHT
import com.example.myapplication.android.presentation.components.RecipeImage
import com.example.myapplication.android.presentation.recipe_detail.components.LoadingRecipeShimmer
import com.example.myapplication.android.presentation.recipe_detail.components.RecipeView
import com.example.myapplication.android.presentation.recipe_list.components.RecipeCard
import com.example.myapplication.android.presentation.theme.AppTheme
import com.example.myapplication.domain.model.Recipe
import com.example.myapplication.presentation.recipe_detail.RecipeDetailEvents
import com.example.myapplication.presentation.recipe_detail.RecipeDetailState
import io.ktor.utils.io.*

@ExperimentalStdlibApi
@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun RecipeDetailScreen(
    state: RecipeDetailState,
    onTriggerEvent: (RecipeDetailEvents)->Unit 
) {
    AppTheme(displayProgressBar = state.isLoading) {
        if (state.recipe == null && state.isLoading) {
            LoadingRecipeShimmer(imageHeight = RECIPE_IMAGE_HEIGHT.dp)
        } else if(state.recipe ==  null){
            Text(
                text = "Unable to retrieve the details for recipe",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                style = MaterialTheme.typography.body1
            )
        } else{
            RecipeView(recipe = state.recipe!!)
        }
    }

}
