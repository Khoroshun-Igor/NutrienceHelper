package com.tamago.firebase.data.repository

import android.net.Uri
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.UploadTask
import com.tamago.firebase.domain.repository.ProfileRepository
import com.tamago.firebase.util.Constants.IMAGE_COLLECTION
import com.tamago.firebase.util.Constants.USER_COLLECTION
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Igor Khoroshun on 27.09.2024.
 */

@Singleton
class ProfileRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firebaseFirestore: FirebaseFirestore,
    private val firebaseStorage: FirebaseStorage,
) : ProfileRepository {

    override suspend fun getUserId(): String {
        var uId = ""
        firebaseAuth.currentUser?.uid?.let {
            uId = it
        }
        return uId
    }

    override suspend fun getUser(): Task<QuerySnapshot?> =
        firebaseFirestore.collection(USER_COLLECTION)
            .document(getUserId())
            .collection("info")
            .get()

    override suspend fun getProfileImage(): Task<DocumentSnapshot?> =
        firebaseFirestore.collection(IMAGE_COLLECTION).document(getUserId()).get()

    override suspend fun saveProfileImage(imageUrl: String): Task<Void?> {
        val data = mapOf(
            "image" to imageUrl
        )
        val userId = getUserId()
        return firebaseFirestore.collection(IMAGE_COLLECTION).document(userId).set(data)
    }

    override suspend fun uploadProfileImage(image: Uri): UploadTask {
        val userId = getUserId()
        val imageName = "$userId.jpg"
        return firebaseStorage.reference.child("images").child(imageName).putFile(image)
    }
}
