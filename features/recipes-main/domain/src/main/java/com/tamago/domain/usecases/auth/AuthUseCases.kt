package com.tamago.domain.usecases.auth

/**
 * Created by Igor Khoroshun on 30.09.2024.
 */

data class AuthUseCases(
    val signInWithEmailAndPasswordUseCase: SignInWithEmailAndPasswordUseCase,
    val signUpWithEmailAndPasswordUseCase: SignUpWithEmailAndPasswordUseCase,
    val signOutUseCase: SignOutUseCase,
)
