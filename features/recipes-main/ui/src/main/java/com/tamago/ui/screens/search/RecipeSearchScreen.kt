package com.tamago.ui.screens.search

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.tamago.recipes_uikit.R
import com.tamago.ui.components.bars.RecipesSearchBar
import com.tamago.ui.components.bars.TopBar
import com.tamago.ui.components.states.RecipesStateContent
import com.tamago.ui.navigation.AppNavigation
import com.tamago.ui.screens.signin.SignInScreen
import kotlinx.coroutines.launch

/**
 * Created by Igor Khoroshun on 30.08.2024.
 */

@Composable
internal fun RecipeSearchScreen(
    viewModel: RecipeSearchViewModel,
    modifier: Modifier = Modifier,
    navigationAction: AppNavigation? = null
) {
    val state by viewModel.recipeList.collectAsState()
    val currentState = state
    var query by remember { mutableStateOf("") }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                SignInScreen(
                    closeDrawer = {
                        IconButton(onClick = { scope.launch { drawerState.close() } }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = stringResource(R.string.menu),
                            )
                        }
                    },
                    navigationAction = navigationAction
                )
            }
        },
        gesturesEnabled = true
    ) {
        Scaffold(
            topBar = {
                TopBar(
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = stringResource(R.string.menu),
                            )
                        }
                    },
                    actions = {},
                    title = {
                        RecipesSearchBar(
                            query = query,
                            onQueryChange = { query = it },
                            onSearch = { viewModel.onSearchEvent(query) },
                            currentState = currentState
                        )
                    }
                )
            },
            content = {
                RecipesStateContent(
                    currentState = currentState,
                    modifier = modifier.padding(it),
                    navigationAction = navigationAction,
                )
            }
        )
    }
}
