package com.tamago.ui.components.states

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import com.tamago.recipes_uikit.R
import com.tamago.ui.navigation.AppNavigation
import com.tamago.ui.viewmodels.State

/**
 * Created by Igor Khoroshun on 30.08.2024.
 */

@Composable
internal fun RecipesStateContent(
    currentState: State,
    navigationAction: AppNavigation?
) {
    when (currentState) {
        is State.None -> Unit
        is State.Error -> ErrorMessage(state = currentState)
        is State.Loading -> ProgressIndicator(state = currentState)

        State.None -> {
            Box(contentAlignment = Alignment.Center) {
                Text(text = stringResource(R.string.no_recipes))
            }
        }

        is State.Success -> RecipesListScreen(
            currentState = currentState.recipes,
            navigationAction = navigationAction
        )
    }
}
