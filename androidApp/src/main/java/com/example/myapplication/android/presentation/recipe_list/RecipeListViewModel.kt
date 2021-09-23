package com.example.myapplication.android.presentation.recipe_list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.interactors.recipe_list.SearchRecipes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val searchRecipes: SearchRecipes
) : ViewModel() {

    init {
        loadRecipes()
    }
    private fun loadRecipes() {
        searchRecipes.execute(
            page = 1,
            query = "chicken"
        ).onEach {dataState ->
            println("RecipeListVm: ${dataState.isLoading}")

            dataState.data?.let {recipes ->
                println("RecipeListVm: $recipes")
            }

            dataState.message?.let {message ->
                println("RecipeListVm: $message")
            }
        }.launchIn(viewModelScope)
    }
}
