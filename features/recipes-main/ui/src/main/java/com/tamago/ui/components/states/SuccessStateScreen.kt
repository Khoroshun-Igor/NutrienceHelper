package com.tamago.ui.components.states

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tamago.domain.model.RecipeUI
import com.tamago.ui.components.RecipeCard
import com.tamago.ui.navigation.AppNavigation

/**
 * Created by Igor Khoroshun on 30.08.2024.
 */

@Composable
internal fun RecipesListScreen(
    currentState: List<RecipeUI>,
    navigationAction: AppNavigation? = null,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 180.dp)) {
        items(currentState) { recipe ->
            key(recipe.id) {
                RecipeCard(
                    recipe = recipe,
                    navigationAction = navigationAction,
                    modifier = modifier
                )
            }
        }
    }
}
