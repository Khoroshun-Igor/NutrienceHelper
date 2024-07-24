package com.tamago.spoonacularapi.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Igor Khoroshun on 30.05.2024.
 */

@Serializable
data class ResponseDto<E>(
    @SerialName("offset")
    val offset: Int,
    @SerialName("number")
    val number: Int,
    @SerialName("results")
    val results: Set<E>,
    @SerialName("totalResults")
    val totalResults: Int
)
