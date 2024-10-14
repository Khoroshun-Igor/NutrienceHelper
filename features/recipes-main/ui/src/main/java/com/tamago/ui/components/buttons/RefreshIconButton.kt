package com.tamago.ui.components.buttons

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.tamago.recipes_uikit.R

/**
 * Created by Igor Khoroshun on 06.10.2024.
 */

@Composable
fun RefreshIconButton(
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = Icons.Default.Refresh,
            contentDescription = stringResource(R.string.refresh),
        )
    }
}
