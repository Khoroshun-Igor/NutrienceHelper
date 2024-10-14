package com.tamago.ui.components.states

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tamago.ui.components.RecipesCarousel
import com.tamago.ui.navigation.AppNavigation
import com.tamago.ui.screens.main.State

/**
 * Created by Igor Khoroshun on 30.08.2024.
 */

@Composable
internal fun RecipesMainContent(
    currentState: State,
    modifier: Modifier = Modifier,
    navigationAction: AppNavigation? = null,
) {
    when (currentState) {
        is State.None -> Unit
        is State.Error -> ErrorMessage(
            state = currentState,
            modifier = modifier,
            navigationAction = navigationAction,
        )
        is State.Loading -> ProgressIndicator(
            state = currentState,
            modifier = modifier,
            navigationAction = navigationAction,
        )
        is State.Success -> RecipesCarousel(
            recipeState = currentState.recipes,
            modifier = modifier,
            navigationAction = navigationAction,
        )
    }
}
