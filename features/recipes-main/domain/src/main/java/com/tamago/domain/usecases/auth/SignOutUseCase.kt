package com.tamago.domain.usecases.auth

import com.tamago.firebase.domain.repository.AuthRepository
import com.tamago.firebase.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Created by Igor Khoroshun on 30.09.2024.
 */
class SignOutUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(): Flow<Response<Unit>> {
        val flow = flow {
            try {
                emit(Response.Loading)
                val result = authRepository.signOut()
                emit(Response.Success(result))
            } catch (e: Exception) {
                emit(Response.Error(e))
            }
        }
        return flow
    }
}
