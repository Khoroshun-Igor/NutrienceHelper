@file:Suppress("UnusedParameter")

package com.tamago.recipedata.util

/**
 * Created by Igor Khoroshun on 02.06.2024.
 */
public interface MergeStrategy<E> {
    public fun merge(cache: E, server: E,): E
}

internal class DefaultRequestResponseMergeStrategy<T : Any> : MergeStrategy<RequestResult<T>> {
    override fun merge(cache: RequestResult<T>, server: RequestResult<T>): RequestResult<T> {
        return when {
            cache is RequestResult.InProgress && server is RequestResult.InProgress ->
                merge(cache, server)

            cache is RequestResult.Success && server is RequestResult.InProgress ->
                merge(cache, server)

            cache is RequestResult.InProgress && server is RequestResult.Success ->
                merge(cache, server)

            cache is RequestResult.Success && server is RequestResult.Success ->
                merge(cache, server)

            cache is RequestResult.InProgress && server is RequestResult.Error ->
                merge(cache, server)

            cache is RequestResult.Error && server is RequestResult.InProgress ->
                merge(cache, server)

            cache is RequestResult.Success && server is RequestResult.Error ->
                merge(cache, server)

            cache is RequestResult.Error && server is RequestResult.Success ->
                merge(cache, server)

            cache is RequestResult.Error && server is RequestResult.Error ->
                merge(cache, server)

            else -> error("Unimplemented branch")
        }
    }

    private fun merge(
        cache: RequestResult.InProgress<T>,
        server: RequestResult.InProgress<T>,
    ): RequestResult<T> {
        return when {
            server.data != null -> RequestResult.InProgress(server.data)
            else -> RequestResult.InProgress(cache.data)
        }
    }

    private fun merge(
        cache: RequestResult.Success<T>,
        server: RequestResult.InProgress<T>,
    ): RequestResult<T> {
        return RequestResult.InProgress(cache.data)
    }

    private fun merge(
        cache: RequestResult.InProgress<T>,
        server: RequestResult.Success<T>,
    ): RequestResult<T> {
        return RequestResult.InProgress(server.data)
    }

    private fun merge(
        cache: RequestResult.Success<T>,
        server: RequestResult.Success<T>,
    ): RequestResult<T> {
        return RequestResult.Success(server.data)
    }

    private fun merge(
        cache: RequestResult.InProgress<T>,
        server: RequestResult.Error<T>,
    ): RequestResult<T> {
        return RequestResult.Error(server.data ?: cache.data, error = server.error)
    }

    private fun merge(
        cache: RequestResult.Error<T>,
        server: RequestResult.InProgress<T>,
    ): RequestResult<T> {
        return RequestResult.Error(cache.data ?: server.data, error = cache.error)
    }

    private fun merge(
        cache: RequestResult.Success<T>,
        server: RequestResult.Error<T>,
    ): RequestResult<T> {
        return RequestResult.Error(cache.data, server.error)
    }

    private fun merge(
        cache: RequestResult.Error<T>,
        server: RequestResult.Success<T>,
    ): RequestResult<T> {
        return RequestResult.Error(server.data, cache.error)
    }

    private fun merge(
        cache: RequestResult.Error<T>,
        server: RequestResult.Error<T>,
    ): RequestResult<T> {
        return RequestResult.Error(error("Fatal error"))
    }
}
