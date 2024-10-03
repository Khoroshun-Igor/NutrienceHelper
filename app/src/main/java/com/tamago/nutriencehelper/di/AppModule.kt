package com.tamago.nutriencehelper.di

import com.tamago.common.AppDispatchers
import com.tamago.common.Logger
import com.tamago.common.androidLogcatLogger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by Igor Khoroshun on 06.06.2024.
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideLogger(): Logger = androidLogcatLogger()

    @Provides
    fun provideAppCoroutineDispatchers(): AppDispatchers = AppDispatchers()
}
