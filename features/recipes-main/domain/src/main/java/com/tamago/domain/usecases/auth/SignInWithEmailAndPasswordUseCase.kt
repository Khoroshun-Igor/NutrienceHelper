package com.tamago.domain.usecases.auth

import com.tamago.firebase.domain.repository.AuthRepository
import com.tamago.firebase.util.Response
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

/**
 * Created by Igor Khoroshun on 30.09.2024.
 */
class SignInWithEmailAndPasswordUseCase(
    private val authRepository: AuthRepository
) {
    operator fun invoke(email: String, password: String) = flow {
        try {
            emit(Response.Loading)
            emit(
                Response.Success(authRepository.signInWithEmailAndPassword(email, password).await())
            )
        } catch (e: Exception) {
            emit(Response.Error(e))
        }
    }
}
