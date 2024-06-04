package com.tamago.spoonacularapi.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class SortDirection{
    @SerialName("asc")
    ASC,
    @SerialName("desc")
    DESC
}