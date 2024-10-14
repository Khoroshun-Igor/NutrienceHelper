package com.tamago.ui.components.states

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.tamago.recipes_uikit.R
import com.tamago.ui.components.RecipesCarousel
import com.tamago.ui.navigation.AppNavigation
import com.tamago.ui.screens.main.State

/**
 * Created by Igor Khoroshun on 30.08.2024.
 */

@Composable
internal fun ErrorMessage(
    state: State.Error,
    modifier: Modifier = Modifier,
    navigationAction: AppNavigation? = null,
) {
    val context = LocalContext.current
    val message = stringResource(R.string.error_during_update)
    Column {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        val recipes = state.recipes
        if (recipes != null) {
            RecipesCarousel(
                recipeState = recipes,
                modifier = modifier,
                navigationAction = navigationAction,
            )
        }
    }
}
