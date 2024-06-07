package com.tamago.spoonacularapi.utils

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Igor Khoroshun on 31.05.2024.
 */
//internal class RecipeApiKeyInterceptor(private val apiKey: String) : Interceptor {
//    override fun intercept(chain: Interceptor.Chain): Response {
//        return chain.proceed(
//            chain.request().newBuilder()
//            .addHeader("x-api-key", apiKey)
//            .build()
//        )
//    }
//}