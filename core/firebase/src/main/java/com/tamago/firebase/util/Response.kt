package com.tamago.firebase.util

/**
 * Created by Igor Khoroshun on 21.09.2024.
 */

sealed class Response<out T> {
    data class Success<out T>(val data: T?) : Response<T>()
    data class Error(val e: Exception) : Response<Nothing>()
    data object Loading : Response<Nothing>()
}
