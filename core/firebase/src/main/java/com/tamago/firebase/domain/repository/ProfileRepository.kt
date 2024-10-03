package com.tamago.firebase.domain.repository

import android.net.Uri
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.storage.UploadTask

/**
 * Created by Igor Khoroshun on 27.09.2024.
 */
interface ProfileRepository {

    suspend fun getUserId(): String

    suspend fun getUser(): Task<QuerySnapshot?>

    suspend fun getProfileImage(): Task<DocumentSnapshot?>

    suspend fun saveProfileImage(imageUrl: String): Task<Void?>

    suspend fun uploadProfileImage(image: Uri): UploadTask

//    suspend fun sendEmailVerification(): FirebaseUser
//
//    suspend fun sendPasswordResetEmail(email: String): FirebaseUser
//
//    suspend fun revokeAccess(): FirebaseUser?
}
