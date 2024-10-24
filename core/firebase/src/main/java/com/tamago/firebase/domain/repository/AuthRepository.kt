package com.tamago.firebase.domain.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.firestore.DocumentReference
import com.tamago.firebase.domain.model.User

/**
 * Created by Igor Khoroshun on 23.09.2024.
 */

interface AuthRepository {
    suspend fun signUpWithEmailAndPassword(
        email: String,
        password: String
    ): Task<AuthResult>
    suspend fun saveUser(
        userId: String,
        user: User
    ): Task<DocumentReference?>
    suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): Task<AuthResult>
    suspend fun signInWithGoogle(credential: AuthCredential): Task<AuthResult>
    suspend fun signOut()
}
