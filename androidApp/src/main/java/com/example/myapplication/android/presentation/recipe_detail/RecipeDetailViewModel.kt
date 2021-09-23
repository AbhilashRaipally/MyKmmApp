package com.example.myapplication.android.presentation.recipe_detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.datasource.network.RecipeService
import com.example.myapplication.domain.model.Recipe
import com.example.myapplication.domain.util.DateTimeUtil
import com.example.myapplication.interactors.recipe_detail.GetRecipe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalStdlibApi
@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getRecipe: GetRecipe
): ViewModel(){
    val recipe: MutableState<Recipe?> = mutableStateOf(null)
    init{
        savedStateHandle.get<Int>("recipeId")?.let { recipeId ->
            viewModelScope.launch {
                getRecipe(recipeId = recipeId)
            }
        }
    }

    private fun getRecipe(recipeId:Int){
        getRecipe.execute(recipeId = recipeId).onEach {dataState ->
            println("RecipeListVm: ${dataState.isLoading}")

            dataState.data?.let {recipe ->
                println("RecipeDetailsVm: ${recipe}")
                this.recipe.value = recipe
            }

            dataState.message?.let {message ->
                println("RecipeDetailsVm: ${message}")
            }
        }.launchIn(viewModelScope)
    }

}