package com.tamago.ui.screens.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.tamago.recipes_uikit.R
import com.tamago.ui.components.buttons.NavigateToSignUpButton
import com.tamago.ui.components.buttons.SignInButton
import com.tamago.ui.components.textfields.EmailTextField
import com.tamago.ui.components.textfields.NameTextField
import com.tamago.ui.components.textfields.PasswordTextField
import com.tamago.ui.components.textfields.RepeatPasswordTextField
import com.tamago.ui.navigation.AppNavigation
import kotlinx.coroutines.delay

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
    var email by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repeatedPassword by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = modifier.padding(dimensionResource(R.dimen.middle_padding))
        ) {
            NameTextField(
                value = name,
                onValueChange = { name = it },
            )
        }

        Row(
            modifier = modifier.padding(dimensionResource(R.dimen.middle_padding))
        ) {
            EmailTextField(
                value = email,
                onValueChange = { email = it },
            )
        }

        Row(
            modifier = modifier
                .padding(
                    horizontal = dimensionResource(R.dimen.middle_padding),
                )
                .padding(top = dimensionResource(R.dimen.middle_padding))
        ) {
            PasswordTextField(
                value = password,
                onValueChange = { password = it },
                onDoneClickable = { onSignUpClick(name, email, password) }
            )
        }

        Row(
            modifier = modifier
                .padding(
                    horizontal = dimensionResource(R.dimen.middle_padding),
                )
                .padding(top = dimensionResource(R.dimen.middle_padding))
        ) {
            RepeatPasswordTextField(
                value = repeatedPassword,
                onValueChange = { repeatedPassword = it },
                onDoneClickable = { onSignUpClick(name, email, password) }
            )
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxWidth()
        ) {
            SignInButton(
                title = stringResource(R.string.sign_up),
                onClick = { onSignUpClick(name, email, password) },
                loading = isLoading,
                success = isAuthenticated,
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = modifier.padding(dimensionResource(R.dimen.middle_padding))
        ) {
            Text(stringResource(R.string.already_registered))
            TextButton(onClick = { /*TODO*/ }) {
                Text(stringResource(R.string.sign_in))
            }
        }
        Row {
            Button(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    painterResource(R.drawable.ic_google_logo),
                    contentDescription = stringResource(R.string.login_via_google)
                )
                Text(
                    stringResource(R.string.login_via_google)
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .padding(dimensionResource(R.dimen.middle_padding))
                .fillMaxWidth()
        ) {
            Box(
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    stringResource(R.string.have_no_account_yet),
                    modifier.wrapContentSize(align = Alignment.Center),
                )
            }
            Spacer(modifier = modifier.weight(1f))
            Box(
                contentAlignment = Alignment.CenterEnd
            ) {
                NavigateToSignUpButton(
                    title = stringResource(R.string.sign_up),
                    onClick = { /*TODO*/ },
                )
            }
        }
    }
    LaunchedEffect(key1 = isAuthenticated) {
        if (isAuthenticated) {
            delay(1_000)
            navigationAction?.navigateToMain()
        }
    }
}
