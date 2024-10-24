package com.tamago.domain.usecases.auth

import com.tamago.firebase.domain.repository.AuthRepository
import com.tamago.firebase.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

/**
 * Created by Igor Khoroshun on 30.09.2024.
 */
class SignOutUseCase(
    private val authRepository: AuthRepository
) {
    operator fun invoke(): Flow<Response<Unit>> = flow {
        try {
            emit(Response.Loading)
            val result = authRepository.signOut()
            emit(Response.Success(result))
        } catch (e: IOException) {
            emit(Response.Error(e))
        }
    }
}
