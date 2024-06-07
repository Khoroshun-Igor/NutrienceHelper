package com.tamago.nutriencehelper

import android.content.Context
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.skydoves.retrofit.adapters.result.ResultCallAdapterFactory
import com.tamago.common.AndroidLogcatLogger
import com.tamago.common.AppDispatchers
import com.tamago.common.Logger
import com.tamago.recipe.database.RecipesDataBase
import com.tamago.spoonacularapi.SpoonacularApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Named
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

/**
 * Created by Igor Khoroshun on 06.06.2024.
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Named("OkHttp")
    fun provideOkHttp(@ApplicationContext context: Context): OkHttpClient{
        val apiKey = BuildConfig.RECIPE_API_KEY
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                chain.proceed(
                    chain.request()
                        .newBuilder()
                        .addHeader("x-api-key", apiKey)
                        .build()
                )
            }.build()
    }

    @Provides
    @Named("Retrofit")
    fun provideRetrofit(@Named("OkHttp") okHttpClient: OkHttpClient): Retrofit{
        val baseUrl = BuildConfig.RECIPE_API_BASE_URL
        val converterFactory = Json { ignoreUnknownKeys = true }
            .asConverterFactory("application/json".toMediaType())
        return Retrofit.Builder()
            .addConverterFactory(converterFactory)
            .baseUrl(baseUrl)
            .addCallAdapterFactory(ResultCallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun providesSpoonacularService(@Named("Retrofit") retrofit: Retrofit): SpoonacularApi {
        return retrofit.create(SpoonacularApi::class.java)
    }

    @Provides
    fun provideLogger(): Logger = AndroidLogcatLogger()

//    @Provides
//    @Singleton
//    fun provideRecipeApi(): SpoonacularApi{
//        return SpoonacularApi(
//            baseUrl = BuildConfig.RECIPE_API_BASE_URL,
//            apiKey = BuildConfig.RECIPE_API_KEY,
//        )
//    }

    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): RecipesDataBase = RecipesDataBase(context)

    @Provides
    fun provideAppCoroutineDispatchers(): AppDispatchers = AppDispatchers()
}