package com.tamago.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
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
import com.tamago.ui.viewmodels.RecipeMainViewModel
import kotlinx.coroutines.launch

/**
 * Created by Igor Khoroshun on 31.05.2024.
 */

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
                    viewModel = viewModel,
                    modifier = modifier.padding(it),
                    navigationAction = navigationAction
                )
            }
        )
    }
}

@Suppress("UnusedParameter")
@Composable
internal fun RecipeStateContent(
    viewModel: RecipeMainViewModel,
    modifier: Modifier = Modifier,
    navigationAction: AppNavigation?
) {
    val state by viewModel.state.collectAsState()
    val currentState = state
    RecipesStateContent(
        currentState = currentState,
        navigationAction = navigationAction
    )
}
