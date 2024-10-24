package com.tamago.firebase.data.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.tamago.firebase.domain.model.User
import com.tamago.firebase.domain.repository.AuthRepository
import com.tamago.firebase.util.Constants.USER_COLLECTION
import javax.inject.Inject

/**
 * Created by Igor Khoroshun on 21.09.2024.
 */

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firebaseFirestore: FirebaseFirestore,
) : AuthRepository {
    override suspend fun signUpWithEmailAndPassword(
        email: String,
        password: String
    ) = firebaseAuth.createUserWithEmailAndPassword(email, password)

    override suspend fun saveUser(userId: String, user: User): Task<DocumentReference?> =
        firebaseFirestore
            .collection(USER_COLLECTION)
            .document(userId)
            .collection("info")
            .add(user)

    override suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ) = firebaseAuth.signInWithEmailAndPassword(email, password)

    override suspend fun signInWithGoogle(credential: AuthCredential) =
        firebaseAuth.signInWithCredential(credential)

    override suspend fun signOut() = firebaseAuth.signOut()
}
