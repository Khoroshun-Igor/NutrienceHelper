package com.tamago.ui.screens.detail

import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.tamago.recipes_uikit.R
import com.tamago.ui.components.bars.BottomBar
import com.tamago.ui.components.bars.TopBar
import com.tamago.ui.components.buttons.RefreshIconButton
import com.tamago.ui.navigation.AppNavigation
import com.tamago.ui.screens.signin.SignInScreen
import kotlinx.coroutines.launch

/**
 * Created by Igor Khoroshun on 15.08.2024.
 */

@Suppress("UnusedParameter")
@Composable
fun RecipeInfoUIScreen(
    viewModel: RecipeInformationViewModel,
    recipeId: Int,
    modifier: Modifier = Modifier,
    navigationAction: AppNavigation? = null
) {
    val recipeState by viewModel.recipeUiState.collectAsState()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

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
                    },
                    actions = {
                        RefreshIconButton(onClick = { /*TODO*/ })
                    },
                    title = {
                        Text(
                            text = stringResource(R.string.app_name),
                            modifier = modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                )
            },
            bottomBar = { BottomBar(navigationAction = navigationAction) },
            content = {
                RecipeInfoContent(
                    recipeState,
                    modifier = modifier.padding(it)
                )
            }
        )
    }
}
