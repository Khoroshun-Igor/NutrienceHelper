package com.tamago.recipesmain.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tamago.recipesmain.model.RecipeUI

/**
 * Created by Igor Khoroshun on 10.06.2024.
 */

@Composable
internal fun RecipeCard(
    recipe: RecipeUI,
    modifier: Modifier = Modifier,
) {
    var isFavorite by remember {
        mutableStateOf(false)
    }
    var isAdded by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier
            .width(180.dp)
            .background(MaterialTheme.colorScheme.surfaceContainer)
    ) {
        Box(
            contentAlignment = Alignment.TopCenter
        ) {
            RecipeImageScreen(recipe = recipe)
            Row(
                verticalAlignment = Alignment.Top,
                modifier = modifier.padding(8.dp)
            ) {
                AddingIconButton(isAdded = isAdded, onClick = { isAdded = !isAdded })
                Spacer(modifier = modifier.weight(1f))
                FavorIconButton(isFavorite = isFavorite, onClick = { isFavorite = !isFavorite })
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column(
                modifier = modifier.width(86.dp)
            ) {
                Text(
                    text = recipe.title,
                    modifier = modifier.width(86.dp),
                    softWrap = true,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
    }
}

@Preview
@Composable
fun RecipeCardPreview() {
    RecipeCard(
        recipe = RecipeUI(
            id = 2,
            title = "Unknown",
            image = "pig",
            imageType = "jpeg"
        )
    )
}
