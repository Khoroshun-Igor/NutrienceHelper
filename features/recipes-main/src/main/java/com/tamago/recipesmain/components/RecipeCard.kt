package com.tamago.recipesmain.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tamago.recipes_uikit.R
import com.tamago.recipesmain.components.buttons.CustomIconButton
import com.tamago.recipesmain.components.buttons.IconsForButtonsEnum
import com.tamago.recipesmain.components.images.RecipeImageScreen
import com.tamago.recipesmain.model.RecipeUI
import com.tamago.recipesmain.navigation.AppNavigation
import com.tamago.recipesuikit.NutrienceHelperTheme

/**
 * Created by Igor Khoroshun on 10.06.2024.
 */

@Composable
internal fun RecipeCard(
    recipe: RecipeUI,
    modifier: Modifier = Modifier,
    navigationAction: AppNavigation? = null
) {
    var isFavorite by remember {
        mutableStateOf(false)
    }
    var isAdded by remember {
        mutableStateOf(false)
    }

    ElevatedCard(
        onClick = { navigationAction?.navigateToDetails(recipe.id) },
        modifier = modifier.width(dimensionResource(R.dimen.recipe_card_width))
            .padding(dimensionResource(R.dimen.min_padding))
    ) {
        Row(modifier = modifier) {
            Box(
                contentAlignment = Alignment.TopCenter
            ) {
                RecipeImageScreen(recipeImage = recipe.image)
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    CustomIconButton(
                        isAdded = isAdded,
                        onClick = { isAdded = !isAdded },
                        addingIconsForButtonsEnum = IconsForButtonsEnum.ADD_TO_RECIPES,
                        modifier = modifier
                    )
                }
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.fillMaxWidth()
                .padding(8.dp)
        ) {
            Column(
                modifier = modifier
            ) {
                Text(
                    text = recipe.title,
                    modifier = modifier.width(dimensionResource(R.dimen.text_width)),
                    maxLines = 2,
                    style = MaterialTheme.typography.labelLarge
                )
            }
            Column(
                modifier = modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.End
            ) {
                CustomIconButton(
                    isAdded = isFavorite,
                    onClick = { isFavorite = !isFavorite },
                    addingIconsForButtonsEnum = IconsForButtonsEnum.ADD_TO_FAVORITE,
                    modifier = modifier
                )
            }
        }
    }
}

@Preview
@Composable
fun RecipeCardPreview() {
    NutrienceHelperTheme {
        RecipeCard(
            recipe = RecipeUI(
                id = 2,
                title = "Unknown Unknown Unknown Unknown Unknown Unknown Unknown Unknown Unknown Unknown Unknown",
                image = "pig",
                imageType = "jpeg"
            )
        )
    }
}
