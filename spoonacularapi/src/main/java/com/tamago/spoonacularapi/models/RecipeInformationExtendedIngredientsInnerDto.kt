package com.tamago.spoonacularapi.models

import com.tamago.spoonacularapi.util.BigDecimalSerializer
import kotlinx.serialization.Serializable
import java.math.BigDecimal

@Serializable
data class RecipeInformationExtendedIngredientsInnerDto(
    val aisle: String,
    @Serializable(with = BigDecimalSerializer::class)
    val amount: BigDecimal,
    val consistency: String,
    val id: Int,
    val image: String,
    val name: String,
    val original: String,
    val originalName: String,
    val unit: String
)
