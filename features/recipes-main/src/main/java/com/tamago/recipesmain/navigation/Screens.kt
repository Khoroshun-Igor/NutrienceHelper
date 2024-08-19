package com.tamago.recipesmain.navigation

/**
 * Created by Igor Khoroshun on 15.08.2024.
 */
sealed class Screens(
    val route: String
) {
    data object Main : Screens(ROUTE_MAIN)
    data object Details : Screens(ROUTE_DETAILS)

    companion object {
        const val ROUTE_MAIN = "main"
        const val ROUTE_DETAILS = "details"
    }
}
