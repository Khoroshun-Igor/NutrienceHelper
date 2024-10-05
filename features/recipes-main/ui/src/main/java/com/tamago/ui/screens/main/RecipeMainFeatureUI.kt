package com.tamago.ui.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.tamago.recipes_uikit.R
import com.tamago.ui.components.bars.BottomBar
import com.tamago.ui.components.bars.TopBar
import com.tamago.ui.components.states.RecipesStateContent
import com.tamago.ui.navigation.AppNavigation
import com.tamago.ui.screens.signin.SignInScreen
import kotlinx.coroutines.launch

/**
 * Created by Igor Khoroshun on 31.05.2024.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeMainScreen(
    viewModel: RecipeMainViewModel,
    modifier: Modifier = Modifier,
    navigationAction: AppNavigation? = null
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val state by viewModel.state.collectAsState()
    val currentState = state
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                SignInScreen(
                    closeDrawer = {
                        IconButton(onClick = { scope.launch { drawerState.close() } }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = stringResource(R.string.menu),
                            )
                        }
                    },
                    navigationAction = navigationAction
                )
            }
        },
        gesturesEnabled = true
    ) {
        Scaffold(
            topBar = {
                TopBar(
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = stringResource(R.string.menu),
                            )
                        }
                    }
                )
            },
            bottomBar = { BottomBar(navigationAction = navigationAction) },
            content = {
                RecipeStateContent(
                    currentState = currentState,
                    modifier = modifier.padding(it),
                    navigationAction = navigationAction
                )
            }
        )
    }
}

@Composable
internal fun RecipeStateContent(
    currentState: State,
    modifier: Modifier = Modifier,
    navigationAction: AppNavigation?
) {
    RecipesStateContent(
        currentState = currentState,
        navigationAction = navigationAction,
        modifier = modifier
    )
}
