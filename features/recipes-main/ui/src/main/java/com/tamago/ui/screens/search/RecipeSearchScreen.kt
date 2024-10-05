package com.tamago.ui.screens.search

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.tamago.ui.components.bars.RecipesSearchBar
import com.tamago.ui.navigation.AppNavigation
import com.tamago.ui.screens.main.RecipeStateContent

/**
 * Created by Igor Khoroshun on 30.08.2024.
 */

@Composable
internal fun RecipeSearchScreen(
    viewModel: RecipeSearchViewModel,
    modifier: Modifier = Modifier,
    navigationAction: AppNavigation? = null
) {
    val state by viewModel.recipeList.collectAsState()
    val currentState = state
    var query by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            RecipesSearchBar(
                query = query,
                onQueryChange = { query = it },
                onClicked = {
                    viewModel.onSearchEvent(query)
                },
                onSearch = {
                    viewModel.onSearchEvent(query)
                },
                currentState = currentState
            )
        },
        content = {
            RecipeStateContent(
                currentState = currentState,
                navigationAction = navigationAction,
                modifier = modifier.padding(it)
            )
        }
    )
}
