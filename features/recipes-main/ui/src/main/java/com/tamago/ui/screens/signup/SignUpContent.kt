package com.tamago.ui.screens.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import com.tamago.ui.components.buttons.GoogleSignInButton
import com.tamago.ui.components.buttons.NavigateToSignUpOrSignInButton
import com.tamago.ui.components.textfields.EmailTextField
import com.tamago.ui.components.textfields.NameTextField
import com.tamago.ui.components.textfields.PasswordTextField
import com.tamago.ui.navigation.AppNavigation

/**
 * Created by Igor Khoroshun on 02.10.2024.
 */

@Composable
fun SignUpContent(
    isLoading: Boolean,
    isAuthenticated: Boolean,
    onSignUpClick: (String, String, String) -> Unit,
    navigationAction: AppNavigation? = null,
    modifier: Modifier = Modifier,
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repeatedPassword by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = dimensionResource(R.dimen.max_padding))
    ) {
        NameTextField(
            value = name,
            onValueChange = { name = it }
        )
        EmailTextField(
            value = email,
            onValueChange = { email = it }
        )
        PasswordTextField(
            value = password,
            onValueChange = { password = it },
            onDoneClickable = {}
        )
        PasswordTextField(
            value = repeatedPassword,
            onValueChange = { repeatedPassword = it },
            onDoneClickable = { onSignUpClick(name, email, password) }
        )
        AuthButton(
            title = stringResource(R.string.sign_up),
            onClick = { onSignUpClick(name, email, password) },
            loading = isLoading,
            success = isAuthenticated,
        )
        NavigateToSignUpOrSignInButton(
            description = stringResource(R.string.already_registered),
            linkTitle = stringResource(R.string.sign_in),
            onNavigationClick = { navigationAction?.navigateToMain() }
        )
        GoogleSignInButton()
    }
    LaunchedEffect(key1 = isAuthenticated) {
        if (isAuthenticated) {
            navigationAction?.navigateToMain()
        }
    }
}

@Preview
@Composable
fun SignUpContentPreview() {
    NutrienceHelperTheme {
        SignUpContent(
            isLoading = false,
            isAuthenticated = false,
            onSignUpClick = { _, _, _ -> TODO() }
        )
    }
}
