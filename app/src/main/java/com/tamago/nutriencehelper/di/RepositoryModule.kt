package com.tamago.nutriencehelper.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.tamago.firebase.data.repository.AuthRepositoryImpl
import com.tamago.firebase.data.repository.ProfileRepositoryImpl
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
object RepositoryModule {
    @Provides
    @Singleton
    fun providesAuthRepository(
        firebaseAuth: FirebaseAuth,
        firebaseFirestore: FirebaseFirestore,
    ): AuthRepository {
        return AuthRepositoryImpl(firebaseAuth, firebaseFirestore)
    }

    @Provides
    @Singleton
    fun providesProfileRepository(
        firebaseAuth: FirebaseAuth,
        firebaseFirestore: FirebaseFirestore,
        firebaseStorage: FirebaseStorage,
    ): ProfileRepository {
        return ProfileRepositoryImpl(firebaseAuth, firebaseFirestore, firebaseStorage)
    }
}
