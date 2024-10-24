package com.tamago.nutriencehelper.di

import android.content.Context
import com.tamago.recipe.database.database.RecipesDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

/**
 * Created by Igor Khoroshun on 23.09.2024.
 */

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): RecipesDataBase = RecipesDataBase(context)
}
