package com.tamago.recipesmain.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tamago.recipesmain.screens.RecipeInfoUI
import com.tamago.recipesmain.screens.RecipeMainScreen
import com.tamago.recipesmain.viewmodels.RecipeMainViewModel

/**
 * Created by Igor Khoroshun on 15.08.2024.
 */

@Composable
internal fun NavigationGraph(
    viewModel: RecipeMainViewModel,
    startDestination: String = Screens.ROUTE_MAIN
) {
    val navController = rememberNavController()
    val navigationAction = remember(navController) {
        AppNavigation(navController)
    }

    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = startDestination) {
            RecipeMainScreen(viewModel = hiltViewModel(), navigationAction = navigationAction)
        }
        composable(
            route = Screens.ROUTE_DETAILS + "/{recipeId}",
            arguments = listOf(
                navArgument("recipeId") {
                    type = NavType.IntType
                    defaultValue = 1
                }
            )
        ) { entry ->
            RecipeInfoUI(
                viewModel = hiltViewModel(),
                recipeId = entry.arguments!!.getInt("recipeId")
            )
        }
    }
}
