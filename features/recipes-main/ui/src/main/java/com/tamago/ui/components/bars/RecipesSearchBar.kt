package com.tamago.ui.components.bars

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
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
    onSearch: (String) -> Unit,
    modifier: Modifier = Modifier,
    currentState: State? = null,
) {
    var expanded by remember {
        mutableStateOf(false)
    }
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
            )
        },
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier.fillMaxWidth(),
        shape = SearchBarDefaults.inputFieldShape,
        tonalElevation = SearchBarDefaults.TonalElevation,
        shadowElevation = SearchBarDefaults.ShadowElevation,
        windowInsets = SearchBarDefaults.windowInsets,
    ) {
    }
}

@Preview
@Composable
fun RecipeSearchBarPreview() {
    NutrienceHelperTheme {
        RecipesSearchBar(
            query = "pizza",
            onQueryChange = { TODO() },
            onSearch = { TODO() },
            currentState = null
        )
    }
}
