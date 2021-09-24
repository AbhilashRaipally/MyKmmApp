package com.example.myapplication.android.presentation.recipe_list

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import com.example.myapplication.android.presentation.recipe_list.components.RecipeList
import com.example.myapplication.android.presentation.recipe_list.components.SearchAppBar
import com.example.myapplication.android.presentation.theme.AppTheme
import com.example.myapplication.presentation.recipe_list.FoodCategory
import com.example.myapplication.presentation.recipe_list.FoodCategoryUtil
import com.example.myapplication.presentation.recipe_list.RecipeListEvents
import com.example.myapplication.presentation.recipe_list.RecipeListState

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun RecipeListScreen(
    state: RecipeListState,
    onTriggerEvent: (RecipeListEvents) -> Unit,
    onClickRecipeItem: (Int) -> Unit,
) {
    AppTheme(displayProgressBar = state.isLoading) {
        val foodCategories = remember{ FoodCategoryUtil().getAllFoodCategories()}
        Scaffold(
            topBar = {
                SearchAppBar(
                    query = state.query,
                    categories = foodCategories,
                    selectedCategory = state.selectedCategory,
                    onSelectedCategoryChanged = {
                        onTriggerEvent(RecipeListEvents.OnSelectCategory(it))
                     },
                    onQueryChange = {
                        onTriggerEvent(RecipeListEvents.OnUpdateQuery(it))
                    }, onExecuteSearch = {
                        onTriggerEvent(RecipeListEvents.NewSearch)
                    })
            }
        ) {
            RecipeList(
                loading = state.isLoading,
                recipes = state.recipes,
                page = state.page,
                onTriggerNextPage = {
                    onTriggerEvent(RecipeListEvents.NextPage)
                },
                onClickRecipeListItem = onClickRecipeItem
            )
        }
    }

}
