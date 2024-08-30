package com.tamago.spoonacularapi.models

import com.tamago.spoonacularapi.util.BigDecimalSerializer
import kotlinx.serialization.Serializable

/**
 * Created by Igor Khoroshun on 16.08.2024.
 */

@Serializable
data class RecipeInformationExtendedIngredientsInnerMeasuresMetricDto(
    @Serializable(with = BigDecimalSerializer::class)
    val amount: java.math.BigDecimal,
    val unitLong: String,
    val unitShort: String
)
