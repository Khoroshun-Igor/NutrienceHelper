package com.tamago.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tamago.ui.screens.detail.RecipeInfoUIScreen
import com.tamago.ui.screens.main.RecipeMainScreen
import com.tamago.ui.screens.main.RecipeMainViewModel
import com.tamago.ui.screens.search.RecipeSearchScreen
import com.tamago.ui.screens.signup.SignUpScreen

/**
 * Created by Igor Khoroshun on 15.08.2024.
 */

@Suppress("UnusedParameter")
@Composable
fun NavigationGraph(
    viewModel: RecipeMainViewModel,
    startDestination: String = Screens.ROUTE_MAIN
) {
    val navController = rememberNavController()
    val navigationAction = remember(navController) {
        AppNavigation(navController)
    }

    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = startDestination) {
            RecipeMainScreen(
                viewModel = hiltViewModel(),
                navigationAction = navigationAction
            )
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
            RecipeInfoUIScreen(
                viewModel = hiltViewModel(),
                recipeId = entry.arguments!!.getInt("recipeId"),
                navigationAction = navigationAction,
            )
        }
        composable(route = Screens.ROUTE_SEARCH) {
            RecipeSearchScreen(
                viewModel = hiltViewModel(),
                navigationAction = navigationAction
            )
        }
        composable(route = Screens.SIGN_UP) {
            SignUpScreen(
                navigationAction = navigationAction,
            )
        }
    }
}
