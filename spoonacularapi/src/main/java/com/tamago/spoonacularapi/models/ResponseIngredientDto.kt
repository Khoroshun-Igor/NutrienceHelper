package com.tamago.spoonacularapi.models

import kotlinx.serialization.Serializable

@Serializable
data class ResponseIngredientDto(
    val results: Set<IngredientDto>,
    val offset: Int,
    val number: Int,
    val totalResults: Int,
)
