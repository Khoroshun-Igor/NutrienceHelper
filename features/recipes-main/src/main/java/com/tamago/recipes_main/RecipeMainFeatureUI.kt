package com.tamago.recipes_main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tamago.recipes_main.components.BottomBar
import com.tamago.recipes_main.components.DrawerNavigationItem
import com.tamago.recipes_main.components.RecipeCard
import com.tamago.recipes_main.components.TopBar
import com.tamago.recipes_main.model.RecipeUI

/**
 * Created by Igor Khoroshun on 31.05.2024.
 */

@Composable
fun RecipeMainScreen(
) {
    NavigationDrawer(viewModel = viewModel())
}

@Composable
internal fun RecipeMainScreen(
    viewModel: RecipeMainViewModel,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar() },
        content = {
            RecipeStateContent(
                viewModel = viewModel,
                modifier = modifier.padding(it)
            )
        }
    )
}

@Composable
internal fun RecipeStateContent(
    viewModel: RecipeMainViewModel,
    modifier: Modifier
){
    val state by viewModel.state.collectAsState()
    when (val currentState = state) {
        is State.Success -> RecipesContent(currentState.recipes)
        is State.Error -> RecipesWithError(currentState.recipes)
        is State.Loading -> RecipesDuringUpdate(currentState.recipes)
        State.None -> RecipesEmpty()
    }
}

@Composable
internal fun RecipesWithError(
    recipes: List<RecipeUI>?
) {
    Box(contentAlignment = Alignment.Center) {
        Text(text = "Error during update")
    }
    Column {
        if (recipes != null) {
            RecipesContent(recipes = recipes)
        }
    }
}

@Composable
internal fun RecipesDuringUpdate(
    recipes: List<RecipeUI>?
) {
    Box(contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
    Column {
        if (recipes != null) {
            RecipesContent(recipes = recipes)
        }
    }
}

@Composable
internal fun RecipesEmpty() {
    Box(contentAlignment = Alignment.Center) {
        Text(text = "No recipes")
    }
}

@Composable
internal fun NavigationDrawer(
    viewModel: RecipeMainViewModel,
    modifier: Modifier = Modifier,
    drawerState: DrawerState = rememberDrawerState(DrawerValue.Closed)
){
    val drawerState = drawerState
    val items = listOf(
        DrawerNavigationItem.Home,
        DrawerNavigationItem.Favorite,
        DrawerNavigationItem.MealPlan,
        DrawerNavigationItem.SignOut
    )

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            Column(
                modifier = modifier
                    .width(320.dp)
                    .padding(32.dp)
                    .background(MaterialTheme.colorScheme.background)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Account",
                        modifier = modifier
                            .padding(8.dp)
                            .size(60.dp)
                    )
                    Text(
                        text = "guest",
                        modifier = modifier.padding(8.dp)
                    )
                }
                HorizontalDivider(
                    modifier = modifier
                        .padding(16.dp)
                )
                items.forEach { item ->
                    if(item.text == "Sign out"){
                        Spacer(modifier = modifier.weight(1f))
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            item.icon,
                            item.text,
                            modifier = modifier
                                .padding(8.dp)
                                .size(32.dp)
                        )
                        Text(
                            item.text,
                            modifier = modifier
                                .padding(8.dp)
                        )
                    }
                }
            }
        }
    ) {
        RecipeMainScreen(viewModel)
    }
}

@Composable
private fun RecipesContent(recipes: List<RecipeUI>) {
    LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 180.dp)) {
        items(recipes){recipe ->
                key(recipe.id) {
                    RecipeCard(recipe)
            }
        }
    }
}