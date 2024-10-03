package com.tamago.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.tamago.ui.components.bars.RecipesSearchBar
import com.tamago.ui.navigation.AppNavigation
import com.tamago.ui.viewmodels.RecipeMainViewModel

/**
 * Created by Igor Khoroshun on 30.08.2024.
 */

@Composable
internal fun RecipeSearchScreen(
    viewModel: RecipeMainViewModel,
    modifier: Modifier = Modifier,
    navigationAction: AppNavigation? = null
) {
    val state by viewModel.state.collectAsState()
    val currentState = state

    Scaffold(
        topBar = {
            RecipesSearchBar(
                query = viewModel.query,
                onQueryChange = { viewModel.query = it },
                onClicked = {
                    viewModel.findRecipes()
                },
                onSearch = {
                    viewModel.findRecipes()
                },
                currentState = currentState
            )
        },
        content = {
            RecipeStateContent(
                viewModel = viewModel,
                navigationAction = navigationAction,
                modifier = modifier.padding(it)
            )
        }
    )
}
