package com.tamago.domain.usecases.auth

import com.tamago.firebase.domain.repository.AuthRepository
import com.tamago.firebase.util.Response
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import java.io.IOException

/**
 * Created by Igor Khoroshun on 30.09.2024.
 */
class SignUpWithEmailAndPasswordUseCase(
    private val authRepository: AuthRepository
) {
    operator fun invoke(name: String, email: String, password: String) = flow {
        try {
            emit(Response.Loading)
            emit(Response.Success(authRepository.signUpWithEmailAndPassword(name, email, password).await()))
        } catch (e: IOException) {
            emit(Response.Error(e))
        }
    }
}
