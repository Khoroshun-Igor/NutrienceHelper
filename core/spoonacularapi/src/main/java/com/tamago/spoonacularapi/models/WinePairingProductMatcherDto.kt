package com.tamago.spoonacularapi.models

import com.tamago.spoonacularapi.util.BigDecimalSerializer
import kotlinx.serialization.Serializable
import java.math.BigDecimal

@Serializable
data class WinePairingProductMatcherDto(
    val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val imageUrl: String,
    @Serializable(with = BigDecimalSerializer::class)
    val averageRating: BigDecimal,
    val ratingCount: Int,
    @Serializable(with = BigDecimalSerializer::class)
    val score: BigDecimal,
    val link: String,
)
