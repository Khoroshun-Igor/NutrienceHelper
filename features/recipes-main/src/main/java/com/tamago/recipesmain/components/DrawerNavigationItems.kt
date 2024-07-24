package com.tamago.recipesmain.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Created by Igor Khoroshun on 10.06.2024.
 */
sealed class DrawerNavigationItems(
    val icon: ImageVector,
    val text: String,
) {
    object Home : DrawerNavigationItems(
        icon = Icons.Default.Home,
        text = "Home"
    )

    object Favorite : DrawerNavigationItems(
        icon = Icons.Default.Favorite,
        text = "Favorite"
    )

    object MealPlan : DrawerNavigationItems(
        icon = Icons.Default.DateRange,
        text = "My meal plan"
    )

    object SignOut : DrawerNavigationItems(
        icon = Icons.AutoMirrored.Default.ExitToApp,
        text = "Sign out"
    )
}
