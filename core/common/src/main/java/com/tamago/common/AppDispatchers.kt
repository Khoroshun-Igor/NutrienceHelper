package com.tamago.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainCoroutineDispatcher

/**
 * Created by Igor Khoroshun on 06.06.2024.
 */
public class AppDispatchers(
    public val default: CoroutineDispatcher = Dispatchers.Default,
    public val io: CoroutineDispatcher = Dispatchers.IO,
    public val main: MainCoroutineDispatcher = Dispatchers.Main,
    public val unconfined: CoroutineDispatcher = Dispatchers.Unconfined
)
