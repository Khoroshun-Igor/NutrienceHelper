package com.tamago.ui.components.bars

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.tamago.recipes_uikit.R
import com.tamago.recipesuikit.NutrienceHelperTheme
import com.tamago.ui.screens.main.State

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
    var expanded by remember {
        mutableStateOf(false)
    }

    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(horizontal = dimensionResource(R.dimen.min_padding))
            .fillMaxWidth()
    ) {
        SearchBar(
            inputField = {
                SearchBarDefaults.InputField(
                    query = query,
                    onQueryChange = onQueryChange,
                    onSearch = {
                        expanded = !expanded
                        onSearch(it)
                    },
                    expanded = expanded,
                    onExpandedChange = { expanded = !expanded },
                    enabled = true,
                    placeholder = { Text(text = stringResource(R.string.search_recipe)) },
                    leadingIcon = null,
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
                    },
                )
            },
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
            modifier = Modifier,
            shape = SearchBarDefaults.inputFieldShape,
            tonalElevation = SearchBarDefaults.TonalElevation,
            shadowElevation = SearchBarDefaults.ShadowElevation,
            windowInsets = SearchBarDefaults.windowInsets,
        ) {}
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
