package com.tamago.ui.components.states

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tamago.ui.navigation.AppNavigation
import com.tamago.ui.viewmodels.State

/**
 * Created by Igor Khoroshun on 30.08.2024.
 */

@Composable
internal fun RecipesStateContent(
    currentState: State,
    navigationAction: AppNavigation? = null,
    modifier: Modifier = Modifier
) {
    when (currentState) {
        is State.None -> Unit
        is State.Error -> ErrorMessage(state = currentState)
        is State.Loading -> ProgressIndicator(state = currentState)
        is State.Success -> RecipesListScreen(
            currentState = currentState.recipes,
            navigationAction = navigationAction,
            modifier = modifier
        )
    }
}