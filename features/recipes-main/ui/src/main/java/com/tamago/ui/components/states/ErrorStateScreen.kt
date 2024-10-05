package com.tamago.ui.components.states

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import com.tamago.recipes_uikit.R
import com.tamago.ui.screens.main.State

/**
 * Created by Igor Khoroshun on 30.08.2024.
 */

@Composable
internal fun ErrorMessage(state: State.Error) {
    Column {
        Box(contentAlignment = Alignment.Center) {
            Text(text = stringResource(R.string.error_during_update))
        }
        val recipes = state.recipes
        if (recipes != null) {
            RecipesListScreen(recipes)
        }
    }
}
