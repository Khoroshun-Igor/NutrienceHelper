package com.tamago.ui.components.states

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.tamago.ui.components.RecipesCarousel
import com.tamago.ui.navigation.AppNavigation
import com.tamago.ui.screens.main.State

/**
 * Created by Igor Khoroshun on 30.08.2024.
 */

@Composable
internal fun ProgressIndicator(
    state: State.Loading,
    modifier: Modifier = Modifier,
    navigationAction: AppNavigation? = null,
) {
    Column {
        Box(contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
        val recipes = state.recipes
        if (recipes != null) {
            RecipesCarousel(
                recipeState = recipes,
                modifier = modifier,
                navigationAction = navigationAction
            )
//            RecipesListScreen(recipes)
        }
    }
}
