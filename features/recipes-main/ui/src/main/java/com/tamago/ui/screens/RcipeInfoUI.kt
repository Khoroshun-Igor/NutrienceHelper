package com.tamago.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.tamago.domain.model.RecipeInfoUI
import com.tamago.recipes_uikit.R
import com.tamago.ui.components.images.RecipeImageScreen
import com.tamago.ui.viewmodels.RecipeInfoState
import com.tamago.ui.viewmodels.RecipeInformationViewModel

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

            else -> {}
        }
    }
}

@Composable
fun RecipeInfoContent(
    recipeInfoUI: RecipeInfoUI,
    modifier: Modifier = Modifier,
) {
    Column {
        Box(modifier = modifier) {
            RecipeImageScreen(
                recipeImage = recipeInfoUI.image,
                modifier = modifier.fillMaxWidth()
            )
            Text(text = recipeInfoUI.readyInMinutes.toString())
            Text(text = recipeInfoUI.healthScore.toString())
        }
        TagsList(recipeInfoUI)
        Text(
            text = recipeInfoUI.title,
            style = MaterialTheme.typography.labelLarge
        )
        HorizontalDivider(thickness = 1.dp)
        Text(
            text = recipeInfoUI.instructions,
            style = MaterialTheme.typography.labelSmall
        )
    }
}

@Composable
fun TagsList(recipeInfoUI: RecipeInfoUI) {
    Row {
        if (recipeInfoUI.cheap) TagField(tagText = "cheap")
        if (recipeInfoUI.dairyFree) TagField(tagText = "dairy free")
        if (recipeInfoUI.glutenFree) TagField(tagText = "gluten free")
        if (recipeInfoUI.lowFodmap) TagField(tagText = "low fodmap")
        if (recipeInfoUI.sustainable) TagField(tagText = "sustainable")
        if (recipeInfoUI.vegan) TagField(tagText = "vegan")
        if (recipeInfoUI.vegetarian) TagField(tagText = "vegetarian")
        if (recipeInfoUI.veryHealthy) TagField(tagText = "very healthy")
        if (recipeInfoUI.veryPopular) TagField(tagText = "very popular")
    }
}

@Composable
fun TagField(tagText: String) {
    SuggestionChip(onClick = { /*TODO*/ }, label = { Text(text = tagText) })
}
