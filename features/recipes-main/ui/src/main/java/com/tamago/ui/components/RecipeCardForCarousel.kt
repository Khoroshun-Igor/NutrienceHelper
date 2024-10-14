package com.tamago.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.tamago.domain.model.RecipeUI
import com.tamago.recipes_uikit.R
import com.tamago.recipesuikit.NutrienceHelperTheme
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
            .padding(dimensionResource(R.dimen.min_padding))
            .size(
                width = dimensionResource(R.dimen.carousel_card_width),
                height = dimensionResource(R.dimen.carousel_card_height)
            )
    ) {
        Column {
            RecipeImageScreen(recipeImage = recipe.image)
            Text(
                text = recipe.title,
                maxLines = 2,
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}

@Preview
@Composable
fun RecipeCardForCarouselPreview() {
    NutrienceHelperTheme {
        RecipeCardForCarousel(
            recipe = RecipeUI(
                1,
                "pizzapizzapizzapizzapizzapizza pizza pizza pizza pizza pizza pizza pizza ",
                "",
                ".jpg"
            )
        )
    }
}
