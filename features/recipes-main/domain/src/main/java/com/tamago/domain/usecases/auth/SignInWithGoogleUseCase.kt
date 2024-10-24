package com.tamago.domain.usecases.auth

import com.google.firebase.auth.AuthCredential
import com.tamago.firebase.domain.repository.AuthRepository
import com.tamago.firebase.util.Response
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import java.io.IOException

/**
 * Created by Igor Khoroshun on 23.10.2024.
 */
class SignInWithGoogleUseCase(
    private val authRepository: AuthRepository
) {
    operator fun invoke(credential: AuthCredential) = flow {
        try {
            emit(Response.Loading)
            val result = authRepository.signInWithGoogle(credential).await()
            emit(
                Response.Success(result)
            )
        } catch (e: IOException) {
            emit(Response.Error(e))
        }
    }
}
