//
//  RecipeListViewModel.swift
//  iosApp
//
//  Created by Abhilash Raipally on 24/09/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

class RecipeListViewModel: ObservableObject {
    //Dependencies
    let searchRecipes: SearchRecipes
    //let foodCategoryUtil: FoodCategoryUtil
    
    @Published var state: RecipeListState = RecipeListState()
    
    init(
        searchRecipes:SearchRecipes
    ){
        self.searchRecipes = searchRecipes
    }
    
}
