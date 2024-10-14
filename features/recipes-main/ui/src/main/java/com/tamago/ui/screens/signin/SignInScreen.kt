package com.tamago.ui.screens.signin

import android.widget.Toast
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.tamago.ui.navigation.AppNavigation

/**
 * Created by Igor Khoroshun on 23.09.2024.
 */

@Composable
fun SignInScreen(
    closeDrawer: @Composable RowScope.() -> Unit,
    navigationAction: AppNavigation? = null,
    modifier: Modifier = Modifier,
) {
    val signInViewModel: SignInViewModel = hiltViewModel()
    val context = LocalContext.current
    val signInState = signInViewModel.signInState

    SignInContent(
        isLoading = signInState.isLoading,
        isAuthenticated = signInState.isAuthenticated,
        onSignInClick = { email, password ->
            signInViewModel.signInWithEmailAndPassword(
                email,
                password,
                onError = { message ->
                    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
                },
                onSuccess = {
                    navigationAction?.navigateToMain()
                }
            )
        },
        closeDrawer = closeDrawer,
        modifier = modifier,
        navigationAction = navigationAction
    )
}
