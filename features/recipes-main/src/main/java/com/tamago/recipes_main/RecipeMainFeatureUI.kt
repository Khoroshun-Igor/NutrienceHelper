package com.tamago.recipes_main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tamago.recipe_data.model.Recipe
import com.tamago.recipes_main.model.RecipeUI

/**
 * Created by Igor Khoroshun on 31.05.2024.
 */

@Composable
fun RecipeMainScreen(
){
    RecipeMainScreen(viewModel = viewModel())
}

@Composable
internal fun RecipeMainScreen(
    viewModel: RecipeMainViewModel
){
    val state by viewModel.state.collectAsState()
    when(val currentState =  state){
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
    Box(contentAlignment = Alignment.Center){
        Text(text = "Error during update")
    }
    Column {
        if(recipes != null){
            RecipesContent(recipes = recipes)
        }
    }
}

@Composable
internal fun RecipesDuringUpdate(
    recipes: List<RecipeUI>?
) {
    Box(contentAlignment = Alignment.Center){
        CircularProgressIndicator()
    }
    Column {
        if(recipes != null){
            RecipesContent(recipes = recipes)
        }
    }
}

@Composable
internal fun RecipesEmpty() {
    Box(contentAlignment = Alignment.Center){
        Text(text = "No recipes")
    }
}

@Composable
private fun RecipesContent(recipes: List<RecipeUI>) {
    LazyColumn {
        items(recipes){recipe ->
            key(recipe.id) {
                RecipeItem(recipe)
            }
        }
    }
}

@Composable
internal fun RecipeItem(recipe: RecipeUI) {
    Column {
        Text(text = recipe.title, style = MaterialTheme.typography.headlineMedium)
    }
}

@Preview
@Composable
internal fun RecipeItemPreview(@PreviewParameter(RecipePreviewProvider::class) recipe: RecipeUI) {
    RecipeItem(recipe = recipe)
}

private class RecipePreviewProvider : PreviewParameterProvider<RecipeUI> {
    override val values = sequenceOf(
        RecipeUI(1, "Pizza", "s", "s")
    )
}