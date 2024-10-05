package com.tamago.domain.usecases.profile

import com.tamago.firebase.domain.model.User
import com.tamago.firebase.domain.repository.AuthRepository
import com.tamago.firebase.domain.repository.ProfileRepository
import com.tamago.firebase.util.Response
import kotlinx.coroutines.flow.flow
import java.io.IOException

/**
 * Created by Igor Khoroshun on 30.09.2024.
 */
class SaveUserUseCases(
    private val authRepository: AuthRepository,
    private val profileRepository: ProfileRepository
) {
    operator fun invoke(user: User) = flow {
        try {
            emit(Response.Loading)
            val userUid = profileRepository.getUserId()
            val result =
                authRepository.saveUser(userId = userUid, user = user)
            emit(Response.Success(result))
        } catch (e: IOException) {
            emit(Response.Error(e))
        }
    }
}
