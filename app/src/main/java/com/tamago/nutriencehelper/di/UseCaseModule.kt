package com.tamago.nutriencehelper.di

import com.tamago.domain.usecases.auth.AuthUseCases
import com.tamago.domain.usecases.auth.SignInWithEmailAndPasswordUseCase
import com.tamago.domain.usecases.auth.SignInWithGoogleUseCase
import com.tamago.domain.usecases.auth.SignOutUseCase
import com.tamago.domain.usecases.auth.SignUpWithEmailAndPasswordUseCase
import com.tamago.domain.usecases.profile.ProfileUseCases
import com.tamago.domain.usecases.profile.SaveProfileImageUseCase
import com.tamago.domain.usecases.profile.SaveUserUseCases
import com.tamago.domain.usecases.profile.UploadProfileImageUseCase
import com.tamago.firebase.domain.repository.AuthRepository
import com.tamago.firebase.domain.repository.ProfileRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Igor Khoroshun on 30.09.2024.
 */

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideAuthUseCases(
        authRepository: AuthRepository
    ): AuthUseCases {
        return AuthUseCases(
            signInWithEmailAndPasswordUseCase = SignInWithEmailAndPasswordUseCase(authRepository),
            signInWithGoogleUseCase = SignInWithGoogleUseCase(authRepository),
            signUpWithEmailAndPasswordUseCase = SignUpWithEmailAndPasswordUseCase(authRepository),
            signOutUseCase = SignOutUseCase(authRepository)
        )
    }

    @Provides
    @Singleton
    fun provideProfileUseCases(
        profileRepository: ProfileRepository,
        authRepository: AuthRepository,
    ): ProfileUseCases {
        return ProfileUseCases(
            saveProfileImageUseCase = SaveProfileImageUseCase(profileRepository),
            saveUserUseCases = SaveUserUseCases(authRepository, profileRepository),
            uploadProfileImageUseCase = UploadProfileImageUseCase(profileRepository)
        )
    }
}
