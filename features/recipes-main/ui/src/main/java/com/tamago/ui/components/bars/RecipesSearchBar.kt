package com.tamago.ui.components.bars

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.tamago.recipes_uikit.R
import com.tamago.recipesuikit.NutrienceHelperTheme
import com.tamago.ui.viewmodels.State

/**
 * Created by Igor Khoroshun on 10.06.2024.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun RecipesSearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onClicked: () -> Unit,
    onSearch: (String) -> Unit,
    modifier: Modifier = Modifier,
    currentState: State? = null,
) {
    var active by remember {
        mutableStateOf(false)
    }
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth()
    ) {
        SearchBar(
            query = query,
            onQueryChange = onQueryChange,
            onSearch = {
                active = !active
                onSearch(it)
            },
            active = active,
            onActiveChange = { active = it },
            trailingIcon = {
                if (currentState is State.Loading) {
                    CircularProgressIndicator()
                } else {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = stringResource(R.string.search)
                    )
                }
            },
            placeholder = { Text(text = stringResource(R.string.search_recipe)) },
            interactionSource = remember {
                MutableInteractionSource()
            }.also { interactionSource ->
                LaunchedEffect(key1 = interactionSource) {
                    interactionSource.interactions.collect { interaction ->
                        if (interaction is PressInteraction.Release) {
                            onClicked.invoke()
                        }
                    }
                }
            }
        ) {
        }
    }
}

@Preview
@Composable
fun RecipeSearchBarPreview() {
    NutrienceHelperTheme {
        RecipesSearchBar(
            query = "pizza",
            onQueryChange = { TODO() },
            onClicked = {},
            onSearch = { TODO() },
            currentState = null
        )
    }
}
