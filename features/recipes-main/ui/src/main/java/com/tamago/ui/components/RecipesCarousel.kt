package com.tamago.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.tamago.domain.model.RecipeUI
import com.tamago.recipes_uikit.R
import com.tamago.ui.navigation.AppNavigation

/**
 * Created by Igor Khoroshun on 05.10.2024.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipesCarousel(
    recipeState: List<RecipeUI>,
    modifier: Modifier = Modifier,
    navigationAction: AppNavigation? = null
) {
    HorizontalMultiBrowseCarousel(
        state = rememberCarouselState { recipeState.size },
        preferredItemWidth = dimensionResource(R.dimen.carousel_card_width),
        itemSpacing = dimensionResource(R.dimen.min_padding),
    ) { i ->
        val recipe = recipeState[i]
        RecipeCardForCarousel(
            recipe,
            modifier = modifier,
            navigationAction = navigationAction
        )
    }
}
