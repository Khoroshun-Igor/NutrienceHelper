package com.tamago.recipes_main.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * Created by Igor Khoroshun on 10.06.2024.
 */

@Composable
internal fun BottomBar(
    modifier: Modifier = Modifier
){
    BottomAppBar(
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "home"
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "search"
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(Icons.Filled.Add, "Add Menu")
            }
        }
    )
}

@Preview
@Composable
internal fun BottomBarPreview(

) {
    BottomBar()
}