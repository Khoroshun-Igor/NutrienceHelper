package com.tamago.ui.navigation

/**
 * Created by Igor Khoroshun on 15.08.2024.
 */
sealed class Screens(
    val route: String
) {
    data object Main : Screens(ROUTE_MAIN)
    data object Details : Screens(ROUTE_DETAILS)
    data object Search : Screens(ROUTE_SEARCH)
    data object SignUp : Screens(SIGN_UP)

    companion object {
        const val ROUTE_MAIN = "main"
        const val ROUTE_DETAILS = "details"
        const val ROUTE_SEARCH = "search"
        const val SIGN_UP = "signup"
    }
}
