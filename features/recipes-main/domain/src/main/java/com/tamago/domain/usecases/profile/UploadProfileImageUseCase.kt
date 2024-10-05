package com.tamago.domain.usecases.profile

import android.net.Uri
import com.tamago.firebase.domain.repository.ProfileRepository
import com.tamago.firebase.util.Response
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import java.io.IOException

/**
 * Created by Igor Khoroshun on 30.09.2024.
 */
class UploadProfileImageUseCase(
    private val profileRepository: ProfileRepository
) {
    operator fun invoke(image: Uri) = flow {
        try {
            emit(Response.Loading)
            val result = profileRepository.uploadProfileImage(image).await()
            emit(Response.Success(result))
        } catch (e: IOException) {
            emit(Response.Error(e))
        }
    }
}
