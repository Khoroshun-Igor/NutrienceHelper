package com.tamago.ui.screens.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tamago.domain.mappers.toTagList
import com.tamago.domain.model.RecipeInfoUI
import com.tamago.recipes_uikit.R
import com.tamago.recipesuikit.NutrienceHelperTheme
import com.tamago.ui.components.images.RecipeImageScreen
import com.tamago.ui.components.tags.RecipeTagList
import com.tamago.ui.components.tags.RoundedTag

/**
 * Created by Igor Khoroshun on 08.10.2024.
 */

@Composable
fun RecipeInfoContent(
    recipeInfoUI: RecipeInfoUI,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Box(
            contentAlignment = Alignment.TopStart,
            modifier = modifier
                .padding(dimensionResource(R.dimen.min_padding))
        ) {
            RecipeImageScreen(
                recipeImage = recipeInfoUI.image,
                modifier = modifier.fillMaxWidth()
            )
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = modifier.fillMaxWidth()
            ) {
                RoundedTag(
                    text = recipeInfoUI.healthScore.toString(),
                    modifier = modifier
                )
            }
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = modifier.fillMaxWidth()
            ) {
                RoundedTag(
                    text = recipeInfoUI.readyInMinutes.toString(),
                    modifier = modifier
                )
            }
        }
        Row(
            modifier = modifier
                .padding(dimensionResource(R.dimen.min_padding))
        ) {
            RecipeTagList(recipeInfoUI.toTagList())
        }
        Text(
            text = recipeInfoUI.title,
            style = MaterialTheme.typography.labelLarge,
        )
        HorizontalDivider(thickness = 1.dp)
        Text(
            text = recipeInfoUI.instructions,
            style = MaterialTheme.typography.labelSmall
        )
    }
}

@Preview
@Composable
fun RecipeInfoContentPreview() {
    NutrienceHelperTheme {
        RecipeInfoContent(
            recipeInfoUI = RecipeInfoUI(
                id = 0,
                title = "Pasta with Garlic, Scallions, Cauliflower & Breadcrumbs",
                image = "",
                servings = 2.0.toBigDecimal(),
                readyInMinutes = 45,
                sourceUrl = "",
                spoonacularSourceUrl = "",
                healthScore = 19.0.toBigDecimal(),
                spoonacularScore = 83.0.toBigDecimal(),
                cheap = false,
                creditsText = "Full Belly Sisters",
                cuisines = emptyList(),
                dairyFree = false,
                diets = emptyList(),
                gaps = "no",
                glutenFree = false,
                instructions = "",
                lowFodmap = false,
                occasions = emptyList(),
                sustainable = false,
                vegan = false,
                vegetarian = false,
                veryHealthy = false,
                veryPopular = false,
                weightWatcherSmartPoints = 17.0.toBigDecimal(),
                dishTypes = listOf(
                    "lunch",
                    "main course",
                    "main dish",
                    "dinner"
                ),
                extendedIngredients = emptySet(),
            )
        )
    }
}
