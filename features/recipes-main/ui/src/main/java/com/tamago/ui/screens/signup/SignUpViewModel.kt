package com.tamago.ui.screens.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tamago.domain.usecases.auth.AuthUseCases
import com.tamago.domain.usecases.profile.ProfileUseCases
import com.tamago.firebase.domain.model.User
import com.tamago.firebase.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Created by Igor Khoroshun on 21.09.2024.
 */

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val authUseCases: AuthUseCases,
    private val profileUseCases: ProfileUseCases,
) : ViewModel() {
    var loadingState by mutableStateOf(false)
        private set

    private fun setLoading(isLoading: Boolean) {
        loadingState = isLoading
    }

    fun signUpWithEmailAndPassword(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit,
    ) {
        authUseCases.signUpWithEmailAndPasswordUseCase.invoke(email, password).onEach { result ->
            when (result) {
                is Response.Error -> {
                    onError(result.e.toString())
                    setLoading(isLoading = false)
                }
                Response.Loading -> setLoading(isLoading = true)
                is Response.Success -> {
                    onSuccess()
                    setLoading(isLoading = false)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun saveUser(
        name: String,
        email: String,
        onError: (String) -> Unit,
        onSuccess: () -> Unit,
    ) {
        profileUseCases.saveUserUseCases.invoke(user = User(name = name, email = email)).onEach { response ->
            when (response) {
                is Response.Error -> onError(response.e.toString())
                Response.Loading -> {}
                is Response.Success -> onSuccess()
            }
        }.launchIn(viewModelScope)
    }
}
