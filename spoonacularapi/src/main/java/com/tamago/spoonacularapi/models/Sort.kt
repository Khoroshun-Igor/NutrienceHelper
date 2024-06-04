package com.tamago.spoonacularapi.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Sort {
    @SerialName("mata-score")
    META_SCORE,
    @SerialName("popularity")
    POPULARITY,
    @SerialName("healthiness")
    HEALTHINESS,
    @SerialName("price")
    PRICE,
    @SerialName("time")
    TIME,
    @SerialName("calories")
    CALORIES,
}