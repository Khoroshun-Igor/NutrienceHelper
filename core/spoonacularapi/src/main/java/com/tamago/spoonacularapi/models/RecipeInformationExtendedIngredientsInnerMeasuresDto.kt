package com.tamago.spoonacularapi.models

import kotlinx.serialization.Serializable

/**
 * Created by Igor Khoroshun on 16.08.2024.
 */

@Serializable
data class RecipeInformationExtendedIngredientsInnerMeasuresDto(
    val metric: RecipeInformationExtendedIngredientsInnerMeasuresMetricDto,
    val us: RecipeInformationExtendedIngredientsInnerMeasuresMetricDto,
)
