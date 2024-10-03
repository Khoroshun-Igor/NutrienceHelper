package com.tamago.domain.usecases.profile

import com.tamago.firebase.domain.repository.ProfileRepository
import com.tamago.firebase.util.Response
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

/**
 * Created by Igor Khoroshun on 30.09.2024.
 */
class SaveProfileImageUseCase(
    private val profileRepository: ProfileRepository
) {
    operator fun invoke(imageUrl: String) = flow {
        try {
            emit(Response.Loading)
            val result = profileRepository.saveProfileImage(imageUrl = imageUrl).await()
            emit(Response.Success(result))
        } catch (e: Exception) {
            emit(Response.Error(e))
        }
    }
}
