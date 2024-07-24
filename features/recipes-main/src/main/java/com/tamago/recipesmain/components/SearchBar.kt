package com.tamago.recipesmain.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.tamago.recipes_uikit.R
import com.tamago.recipesuikit.NutrienceHelperTheme

/**
 * Created by Igor Khoroshun on 10.06.2024.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    onSearchInputChange: (String) -> Unit,
    onClicked: () -> Unit,
    onSearch: (String) -> Unit,
    query: String,
) {
    var active by remember {
        mutableStateOf(false)
    }

    SearchBar(
        query = query,
        onQueryChange = onSearchInputChange,
        onSearch = {
            active = !active
            onSearch(it)
        },
        active = active,
        onActiveChange = { active = it },
        trailingIcon = {
            Icon(Icons.Default.Search, contentDescription = stringResource(R.string.search))
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

@Preview
@Composable
fun SearchBarPreview() {
    NutrienceHelperTheme {
        SearchBar(
            onSearchInputChange = {},
            onClicked = {},
            onSearch = TODO(),
            query = "pizza"
        )
    }
}
