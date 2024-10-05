package com.tamago.ui.screens.signup

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * Created by Igor Khoroshun on 02.10.2024.
 */

@Composable
fun SignUpScreen() {
    val context = LocalContext.current
    val signUpViewModel: SignUpViewModel = hiltViewModel()
    var isSignUp by remember { mutableStateOf(false) }
    var isUserSaved by remember { mutableStateOf(false) }
    val loadingState = signUpViewModel.loadingState

    SignUpContent(
        isLoading = loadingState,
        isAuthenticated = false,
        onSignUpClick = { name, email, password ->
            signUpViewModel.signUpWithEmailAndPassword(
                name = name,
                email = email,
                password = password,
                onSuccess = { isSignUp = true },
                onError = { message ->
                    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
                }
            )
            signUpViewModel.saveUser(
                name = name,
                email = email,
                onSuccess = { isUserSaved = true },
                onError = { message ->
                    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
                }
            )
        },
    )
}
