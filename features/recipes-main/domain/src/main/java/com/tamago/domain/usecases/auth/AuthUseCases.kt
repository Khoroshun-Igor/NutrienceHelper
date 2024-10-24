package com.tamago.domain.usecases.auth

/**
 * Created by Igor Khoroshun on 30.09.2024.
 */

data class AuthUseCases(
    val signInWithEmailAndPasswordUseCase: SignInWithEmailAndPasswordUseCase,
    val signInWithGoogleUseCase: SignInWithGoogleUseCase,
    val signUpWithEmailAndPasswordUseCase: SignUpWithEmailAndPasswordUseCase,
    val signOutUseCase: SignOutUseCase,
)
