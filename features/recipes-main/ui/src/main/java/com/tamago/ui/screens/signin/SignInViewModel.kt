package com.tamago.ui.screens.signin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tamago.domain.usecases.auth.AuthUseCases
import com.tamago.firebase.util.Response
import com.tamago.ui.uistates.SignInUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Created by Igor Khoroshun on 21.09.2024.
 */

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authUseCases: AuthUseCases
) : ViewModel() {

    var signInState by mutableStateOf(SignInUiState())

    fun signInWithEmailAndPassword(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit,
    ) {
        authUseCases.signInWithEmailAndPasswordUseCase.invoke(email, password).onEach { result ->
            signInState = when (result) {
                is Response.Error -> {
                    onError(result.e.toString())
                    SignInUiState()
                }

                Response.Loading -> SignInUiState(isLoading = true)
                is Response.Success -> {
                    onSuccess()
                    SignInUiState(isAuthenticated = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
