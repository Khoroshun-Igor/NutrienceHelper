package com.tamago.ui.screens.signin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.tamago.recipes_uikit.R
import com.tamago.recipesuikit.NutrienceHelperTheme
import com.tamago.ui.components.buttons.AuthButton
import com.tamago.ui.components.buttons.ForgotPasswordTextButton
import com.tamago.ui.components.buttons.GoogleSignInButton
import com.tamago.ui.components.buttons.NavigateToSignUpOrSignInButton
import com.tamago.ui.components.textfields.EmailTextField
import com.tamago.ui.components.textfields.PasswordTextField
import com.tamago.ui.navigation.AppNavigation

/**
 * Created by Igor Khoroshun on 23.09.2024.
 */

@Composable
fun SignInContent(
    isLoading: Boolean,
    onSignInClick: (String, String) -> Unit,
    isAuthenticated: Boolean,
    closeDrawer: @Composable RowScope.() -> Unit,
    modifier: Modifier = Modifier,
    navigationAction: AppNavigation? = null,
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Row(
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.Top,
        content = closeDrawer,
        modifier = modifier.fillMaxWidth()
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = dimensionResource(R.dimen.max_padding)),
    ) {
        EmailTextField(
            value = email,
            onValueChange = { email = it }
        )
        PasswordTextField(
            value = password,
            onValueChange = { password = it },
            onDoneClickable = { onSignInClick(email, password) }
        )
        AuthButton(
            title = stringResource(R.string.sign_in),
            onClick = { onSignInClick(email, password) },
            loading = isLoading,
            success = isAuthenticated,
        )
        Row {
            ForgotPasswordTextButton(
                onClick = { TODO() }
            )
        }
        GoogleSignInButton()
        NavigateToSignUpOrSignInButton(
            description = stringResource(R.string.have_no_account_yet),
            linkTitle = stringResource(R.string.sign_up),
            onNavigationClick = { navigationAction?.navigateToSignUp() }
        )
    }
    LaunchedEffect(key1 = isAuthenticated) {
        if (isAuthenticated) {
            navigationAction?.navigateToMain()
        }
    }
}

@Preview
@Composable
fun SignInContentPreview() {
    NutrienceHelperTheme {
        SignInContent(
            isLoading = false,
            onSignInClick = { _, _ -> TODO() },
            isAuthenticated = false,
            closeDrawer = { },
        )
    }
}
