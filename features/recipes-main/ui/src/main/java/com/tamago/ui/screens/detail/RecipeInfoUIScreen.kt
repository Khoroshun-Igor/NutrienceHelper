package com.tamago.ui.screens.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.tamago.recipes_uikit.R

/**
 * Created by Igor Khoroshun on 15.08.2024.
 */

@Suppress("UnusedParameter")
@Composable
fun RecipeInfoUI(
    viewModel: RecipeInformationViewModel,
    recipeId: Int,
    modifier: Modifier = Modifier,
) {
    val recipeState by viewModel.recipeUiState.collectAsState()

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        when (recipeState) {
            is RecipeInfoState.Error -> {
                Box(contentAlignment = Alignment.Center) {
                    Text(text = stringResource(R.string.error_during_update))
                }
            }

            is RecipeInfoState.Loading -> {
                Box(contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }

            RecipeInfoState.None -> {
                Box(contentAlignment = Alignment.Center) {
                    Text(text = stringResource(R.string.no_recipes))
                }
            }

            is RecipeInfoState.Success -> {
                if (recipeState.recipe != null) {
                    RecipeInfoContent(recipeState.recipe!!)
                }
            }
        }
    }
}
