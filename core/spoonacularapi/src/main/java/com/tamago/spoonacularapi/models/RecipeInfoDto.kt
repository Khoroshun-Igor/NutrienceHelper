package com.tamago.spoonacularapi.models

import com.tamago.spoonacularapi.util.BigDecimalSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.math.BigDecimal

/**
 * Created by Igor Khoroshun on 14.06.2024.
 */

@Serializable
data class RecipeInfoDto(
    @SerialName(value = "id")
    val id: Int,
    @SerialName(value = "title")
    val title: String,
    @SerialName(value = "image")
    val image: String,
    @SerialName(value = "imageType")
    val imageType: String,
    @Serializable(with = BigDecimalSerializer::class)
    @SerialName(value = "servings")
    val servings: BigDecimal,
    @SerialName(value = "readyInMinutes")
    val readyInMinutes: Int,
    @SerialName(value = "license")
    val license: String? = null,
    @SerialName(value = "sourceName")
    val sourceName: String,
    @SerialName(value = "sourceUrl")
    val sourceUrl: String,
    @SerialName(value = "spoonacularSourceUrl")
    val spoonacularSourceUrl: String,
    @SerialName(value = "aggregateLikes")
    val aggregateLikes: Int,
    @Serializable(with = BigDecimalSerializer::class)
    @SerialName(value = "healthScore")
    val healthScore: BigDecimal,
    @Serializable(with = BigDecimalSerializer::class)
    @SerialName(value = "spoonacularScore")
    val spoonacularScore: BigDecimal,
    @Serializable(with = BigDecimalSerializer::class)
    @SerialName(value = "pricePerServing")
    val pricePerServing: BigDecimal,
//    @SerialName(value = "analyzedInstructions")
//    val analyzedInstructions: List<Any>,
    @SerialName(value = "cheap")
    val cheap: Boolean,
    @SerialName(value = "creditsText")
    val creditsText: String,
    @SerialName(value = "cuisines")
    val cuisines: List<String>,
    @SerialName(value = "dairyFree")
    val dairyFree: Boolean,
    @SerialName(value = "diets")
    val diets: List<String>,
    @SerialName(value = "gaps")
    val gaps: String,
    @SerialName(value = "glutenFree")
    val glutenFree: Boolean,
    @SerialName(value = "instructions")
    val instructions: String,
    @SerialName(value = "lowFodmap")
    val lowFodmap: Boolean,
    @SerialName(value = "occasions")
    val occasions: List<String>,
    @SerialName(value = "sustainable")
    val sustainable: Boolean,
    @SerialName(value = "vegan")
    val vegan: Boolean,
    @SerialName(value = "vegetarian")
    val vegetarian: Boolean,
    @SerialName(value = "veryHealthy")
    val veryHealthy: Boolean,
    @SerialName(value = "veryPopular")
    val veryPopular: Boolean,
    @Serializable(with = BigDecimalSerializer::class)
    @SerialName(value = "weightWatcherSmartPoints")
    val weightWatcherSmartPoints: BigDecimal,
    @SerialName(value = "dishTypes")
    val dishTypes: List<String>,
    @SerialName(value = "extendedIngredients")
    val extendedIngredients: Set<RecipeInformationExtendedIngredientsInnerDto>,
    @SerialName(value = "summary")
    val summary: String,
    @SerialName(value = "winePairing")
    val winePairing: WinePairingDto? = null,
    @SerialName(value = "taste")
    val taste: TasteInformationDto? = null
)
