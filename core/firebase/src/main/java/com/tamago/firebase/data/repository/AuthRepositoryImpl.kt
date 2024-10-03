package com.tamago.firebase.data.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
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
        name: String,
        email: String,
        password: String
    ): Task<AuthResult> {
        return firebaseAuth.createUserWithEmailAndPassword(email, password)
    }

    override suspend fun saveUser(userId: String, user: User): Task<DocumentReference?> {
        return firebaseFirestore.collection(USER_COLLECTION).document(userId).collection("info").add(user)
    }

    override suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): Task<AuthResult> {
        return firebaseAuth.signInWithEmailAndPassword(email, password)
    }

    override suspend fun signOut() = firebaseAuth.signOut()

//    override suspend fun sendEmailVerification(): FirebaseUser {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun sendPasswordResetEmail(email: String): FirebaseUser {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun revokeAccess() =
//        firebaseAuth.currentUser?.apply {
//            firebaseFirestore.collection(USER_COLLECTION).document(uid).delete()
//        }
}
