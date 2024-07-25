package com.tamago.spoonacularapi.models

import com.tamago.spoonacularapi.util.BigDecimalSerializer
import kotlinx.serialization.Serializable
import java.math.BigDecimal

/**
 * Created by Igor Khoroshun on 14.06.2024.
 */

@Serializable
data class RecipeInfoDto(
    val id: Int,
    val title: String,
    val image: String,
    val imageType: String,
    @Serializable(with = BigDecimalSerializer::class)
    val servings: BigDecimal,
    val readyInMinutes: Int,
    val license: String,
    val sourceName: String,
    val sourceUrl: String,
    val spoonacularSourceUrl: String,
    val aggregateLikes: Int,
    @Serializable(with = BigDecimalSerializer::class)
    val healthScore: BigDecimal,
    @Serializable(with = BigDecimalSerializer::class)
    val spoonacularScore: BigDecimal,
    @Serializable(with = BigDecimalSerializer::class)
    val pricePerServing: BigDecimal,
    val analyzedInstructions: List<String>,
    val cheap: Boolean,
    val creditsText: String,
    val cuisines: List<String>,
    val dairyFree: Boolean,
    val diets: List<String>,
    val gaps: String,
    val glutenFree: Boolean,
    val instructions: String,
    val ketogenic: Boolean,
    val lowFodmap: Boolean,
    val occasions: List<String>,
    val sustainable: Boolean,
    val vegan: Boolean,
    val vegetarian: Boolean,
    val veryHealthy: Boolean,
    val veryPopular: Boolean,
    val whole30: Boolean,
    @Serializable(with = BigDecimalSerializer::class)
    val weightWatcherSmartPoints: BigDecimal,
    val dishTypes: List<String>,
    val extendedIngredients: Set<RecipeInformationExtendedIngredientsInnerDto>,
    val summary: String,
    val winePairingDto: WinePairingDto,
)
