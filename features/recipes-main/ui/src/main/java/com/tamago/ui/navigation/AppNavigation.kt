package com.tamago.ui.navigation

import androidx.navigation.NavHostController

/**
 * Created by Igor Khoroshun on 15.08.2024.
 */
class AppNavigation(private val navController: NavHostController) {
    fun back() {
        if (navController.previousBackStackEntry != null) {
            navController.popBackStack()
        }
    }

    fun navigateToMain() {
        navController.navigate(Screens.ROUTE_MAIN) {
            popUpTo(Screens.ROUTE_MAIN)
            launchSingleTop = true
            restoreState = true
        }
    }

    fun navigateToDetails(recipeId: Int) {
        navController.navigate(Screens.ROUTE_DETAILS + "/$recipeId") {
            launchSingleTop = true
            restoreState = true
        }
    }

    fun navigateToSearch() {
        navController.navigate(Screens.ROUTE_SEARCH) {
            launchSingleTop = true
            restoreState = true
        }
    }

    fun navigateToSignUp() {
        navController.navigate(Screens.SIGN_UP) {
            launchSingleTop = true
            restoreState = true
        }
    }
}
