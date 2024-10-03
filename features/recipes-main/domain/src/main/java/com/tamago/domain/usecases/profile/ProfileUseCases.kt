package com.tamago.domain.usecases.profile

/**
 * Created by Igor Khoroshun on 30.09.2024.
 */

data class ProfileUseCases(
    val saveProfileImageUseCase: SaveProfileImageUseCase,
    val saveUserUseCases: SaveUserUseCases,
    val uploadProfileImageUseCase: UploadProfileImageUseCase,
)
