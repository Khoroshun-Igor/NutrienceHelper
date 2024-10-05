package com.tamago.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.tamago.domain.model.RecipeUI
import com.tamago.recipes_uikit.R
import com.tamago.ui.components.images.RecipeImageScreen
import com.tamago.ui.navigation.AppNavigation

/**
 * Created by Igor Khoroshun on 05.10.2024.
 */

@Composable
fun RecipeCardForCarousel(
    recipe: RecipeUI,
    modifier: Modifier = Modifier,
    navigationAction: AppNavigation? = null
) {
    ElevatedCard(
        onClick = { navigationAction?.navigateToDetails(recipe.id) },
        modifier = modifier
            .size(
                width = dimensionResource(R.dimen.recipe_card_width),
                height = dimensionResource(R.dimen.carousel_card_height)
            )
    ) {
        Row(modifier = modifier) {
            Box(
                contentAlignment = Alignment.TopCenter
            ) {
                Text(
                    text = recipe.title,
                    modifier = modifier.width(dimensionResource(R.dimen.recipe_card_width)),
                    maxLines = 2,
                    style = MaterialTheme.typography.labelLarge
                )
                RecipeImageScreen(recipeImage = recipe.image)
            }
        }
    }
}
