@file:Suppress("FunctionName")

package com.tamago.common

import android.util.Log

/**
 * Created by Igor Khoroshun on 07.06.2024.
 */
interface Logger {
    fun d(tag: String, message: String)
    fun e(tag: String, message: String)
}

fun androidLogcatLogger(): Logger = object : Logger{
    override fun d(tag: String, message: String) {
        Log.d(tag, message)
    }

    override fun e(tag: String, message: String) {
        Log.e(tag, message)
    }

}