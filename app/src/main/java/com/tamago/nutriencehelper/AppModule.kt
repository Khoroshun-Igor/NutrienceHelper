package com.tamago.nutriencehelper

import android.content.Context
import com.tamago.recipe.database.RecipesDataBase
import com.tamago.recipe_data.RecipesRepository
import com.tamago.spoonacularapi.SpoonacularApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

/**
 * Created by Igor Khoroshun on 06.06.2024.
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRecipeApi(): SpoonacularApi{
        return SpoonacularApi(
            baseUrl = BuildConfig.RECIPE_API_BASE_URL,
            apiKey = BuildConfig.RECIPE_API_KEY
        )
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): RecipesDataBase{
        return RecipesDataBase(context)
    }
}