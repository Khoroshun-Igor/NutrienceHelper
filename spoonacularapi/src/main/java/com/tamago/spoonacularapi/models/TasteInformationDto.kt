package com.tamago.spoonacularapi.models

import com.tamago.spoonacularapi.util.BigDecimalSerializer
import kotlinx.serialization.Serializable
import java.math.BigDecimal

/**
 * Created by Igor Khoroshun on 16.08.2024.
 */

@Serializable
data class TasteInformationDto(
    @Serializable(with = BigDecimalSerializer::class)
    val sweetness: BigDecimal,

    @Serializable(with = BigDecimalSerializer::class)
    val saltiness: BigDecimal,

    @Serializable(with = BigDecimalSerializer::class)
    val sourness: BigDecimal,

    @Serializable(with = BigDecimalSerializer::class)
    val bitterness: BigDecimal,

    @Serializable(with = BigDecimalSerializer::class)
    val savoriness: BigDecimal,

    @Serializable(with = BigDecimalSerializer::class)
    val fattiness: BigDecimal,

    @Serializable(with = BigDecimalSerializer::class)
    val spiciness: BigDecimal
)
