package com.tamago.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.tamago.ui.components.bars.BottomBar
import com.tamago.ui.components.bars.TopBar
import com.tamago.ui.components.states.RecipesStateContent
import com.tamago.ui.navigation.AppNavigation
import com.tamago.ui.viewmodels.RecipeMainViewModel

/**
 * Created by Igor Khoroshun on 31.05.2024.
 */

@Composable
fun RecipeMainScreen(
    viewModel: RecipeMainViewModel,
    modifier: Modifier = Modifier,
    navigationAction: AppNavigation? = null
) {
    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = { BottomBar() },
        content = {
            RecipeStateContent(
                viewModel = viewModel,
                modifier = modifier.padding(it),
                navigationAction = navigationAction
            )
        }
    )
}

@Suppress("UnusedParameter")
@Composable
internal fun RecipeStateContent(
    viewModel: RecipeMainViewModel,
    modifier: Modifier = Modifier,
    navigationAction: AppNavigation?
) {
    val state by viewModel.state.collectAsState()
    val currentState = state
    RecipesStateContent(
        currentState = currentState,
        navigationAction = navigationAction
    )
}


