package com.tamago.recipes_main.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

/**
 * Created by Igor Khoroshun on 10.06.2024.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TopBar(
    modifier: Modifier = Modifier
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    TopAppBar(
        title = {
            Text(
                text = "Nutrience Helper",
                modifier = modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.List,
                contentDescription = "menu"
            )
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "refresh"
                )
            }
        },
        scrollBehavior = scrollBehavior
    )
}

@Preview
@Composable
internal fun TopBarPreview(

) {
    TopBar()
}