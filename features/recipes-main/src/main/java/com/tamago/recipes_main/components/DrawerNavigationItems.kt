package com.tamago.recipes_main.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Created by Igor Khoroshun on 10.06.2024.
 */
sealed class DrawerNavigationItem(
    val icon: ImageVector,
    val text: String,
) {
    object Home: DrawerNavigationItem(
        icon =  Icons.Default.Home,
        text =  "Home"
    )
    object Favorite: DrawerNavigationItem(
        icon =  Icons.Default.Favorite,
        text = "Favorite"
    )
    object MealPlan: DrawerNavigationItem(
        icon = Icons.Default.DateRange,
        text = "My meal plan"
    )
    object SignOut: DrawerNavigationItem(
        icon = Icons.AutoMirrored.Default.ExitToApp,
        text = "Sign out"
    )
}