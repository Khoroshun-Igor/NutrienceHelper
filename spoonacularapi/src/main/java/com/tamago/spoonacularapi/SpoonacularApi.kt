package com.tamago.spoonacularapi

import androidx.annotation.IntRange
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.skydoves.retrofit.adapters.result.ResultCallAdapterFactory
import com.tamago.spoonacularapi.models.RecipeDto
import com.tamago.spoonacularapi.models.ResponseDto
import com.tamago.spoonacularapi.models.Sort
import com.tamago.spoonacularapi.models.SortDirection
import com.tamago.spoonacularapi.utils.RecipeApiKeyInterceptor
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * API Documentation (https://spoonacular.com/food-api/docs)
 */
interface SpoonacularApi {

    val key: String
        get() = "c189afc125b846a7922c67b3fbcf0a55"

    /**
     * API Details (https://api.spoonacular.com/recipes/complexSearch)
     */
    @GET("/recipes/complexSearch")
    fun searchRecipe(
        @Query("query") query: String? = null,
        @Query("number") @IntRange(from = 1, to = 100) number: Int = 100,
        @Query("sort") sort: Sort? = null,
        @Query("sortDirection") sortDirection: SortDirection? = null,
    ): Result<ResponseDto<RecipeDto>>
}

fun SpoonacularApi(
    baseUrl: String,
    apiKey: String,
    okHttpClient: OkHttpClient? = null,
    json: Json = Json,
): SpoonacularApi{
    return retrofit(baseUrl, apiKey, okHttpClient, json).create()
}

private fun retrofit(
    baseUrl: String,
    apiKey: String,
    okHttpClient: OkHttpClient?,
    json: Json,
): Retrofit{
    val converterFactory = json.asConverterFactory(MediaType.get("application/json"))
    val modifiedOkHttpClient = (okHttpClient?.newBuilder() ?: OkHttpClient.Builder())
        .addInterceptor(RecipeApiKeyInterceptor(apiKey))
        .build()

    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(converterFactory)
        .addCallAdapterFactory(ResultCallAdapterFactory.create())
        .client(modifiedOkHttpClient)
        .build()
}