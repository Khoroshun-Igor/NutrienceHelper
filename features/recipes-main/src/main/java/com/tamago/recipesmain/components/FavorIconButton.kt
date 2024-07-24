package com.tamago.recipesmain.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

/**
 * Created by Igor Khoroshun on 24.07.2024.
 */

@Composable
fun FavorIconButton(
    isFavorite: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .clip(RoundedCornerShape(32.dp))
            .size(24.dp),
        content = {
            when {
                isFavorite -> Icon(
                    Icons.Default.Favorite,
                    contentDescription = "Delete from favorite"
                )

                !isFavorite -> Icon(
                    Icons.Default.FavoriteBorder,
                    contentDescription = "Add to favorite"
                )
            }
        }
    )
}
