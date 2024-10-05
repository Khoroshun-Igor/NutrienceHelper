package com.tamago.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tamago.ui.navigation.NavigationGraph
import com.tamago.ui.screens.main.RecipeMainViewModel

/**
 * Created by Igor Khoroshun on 30.08.2024.
 */

@Composable
fun NutrienceHelper() {
    val viewModel: RecipeMainViewModel = viewModel()
    NavigationGraph(viewModel = viewModel)
}
