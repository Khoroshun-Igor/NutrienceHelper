package com.tamago.recipesmain.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tamago.recipes_uikit.R
import com.tamago.recipesmain.components.RecipeCard
import com.tamago.recipesmain.components.bars.BottomBar
import com.tamago.recipesmain.components.bars.TopBar
import com.tamago.recipesmain.components.drawers.DrawerContent
import com.tamago.recipesmain.navigation.AppNavigation
import com.tamago.recipesmain.navigation.NavigationGraph
import com.tamago.recipesmain.viewmodels.RecipeMainViewModel
import com.tamago.recipesmain.viewmodels.State

/**
 * Created by Igor Khoroshun on 31.05.2024.
 */

@Composable
fun NutrienceHelper() {
    val viewModel: RecipeMainViewModel = viewModel()
    NavigationGraph(viewModel = viewModel)
}
@Composable
fun RecipeMainScreen() {
    NavigationDrawer(viewModel = viewModel())
}

@Composable
internal fun RecipeMainScreen(
    viewModel: RecipeMainViewModel,
    modifier: Modifier = Modifier,
    navigationAction: AppNavigation? = null
) {
    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = { BottomBar() },
        content = {
            RecipeStateContent(
                viewModel = viewModel,
                modifier = modifier.padding(it),
                navigationAction = navigationAction
            )
        }
    )
}

@Composable
internal fun RecipeStateContent(
    viewModel: RecipeMainViewModel,
    modifier: Modifier = Modifier,
    navigationAction: AppNavigation?
) {
    val state by viewModel.state.collectAsState()
    val currentState = state
    if (currentState != State.None) {
        RecipesContent(
            currentState = currentState,
            navigationAction = navigationAction
        )
    } else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
        ) {
            Text(text = stringResource(R.string.no_recipes))
        }
    }
}

@Composable
internal fun NavigationDrawer(
    viewModel: RecipeMainViewModel,
    modifier: Modifier = Modifier,
    drawerState: DrawerState = rememberDrawerState(DrawerValue.Closed)
) {
    val drawerState = drawerState

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(
                modifier = modifier
            )
        }
    ) {
        RecipeMainScreen(viewModel)
    }
}

@Composable
private fun RecipesContent(
    currentState: State,
    navigationAction: AppNavigation?
) {
    when (currentState) {
        is State.Error -> {
            Box(contentAlignment = Alignment.Center) {
                Text(text = stringResource(R.string.error_during_update))
            }
        }

        is State.Loading -> {
            Box(contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        State.None -> {
            Box(contentAlignment = Alignment.Center) {
                Text(text = stringResource(R.string.no_recipes))
            }
        }

        is State.Success -> {
            if (currentState.recipes != null) {
                LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 180.dp)) {
                    items(currentState.recipes) { recipe ->
                        key(recipe.id) {
                            RecipeCard(
                                recipe = recipe,
                                navigationAction = navigationAction
                            )
                        }
                    }
                }
            }
        }
    }
}
