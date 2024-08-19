package com.tamago.recipedata.model

import java.math.BigDecimal

/**
 * Created by Igor Khoroshun on 28.06.2024.
 */
data class RecipeInfo(
    val id: Int,
    val title: String,
    val image: String,
    val servings: BigDecimal,
    val readyInMinutes: Int,
    val sourceUrl: String,
    val spoonacularSourceUrl: String,
    val healthScore: BigDecimal,
    val spoonacularScore: BigDecimal,
//    val analyzedInstructions: List<String>,
    val cheap: Boolean,
    val creditsText: String,
    val cuisines: List<String>,
    val dairyFree: Boolean,
    val diets: List<String>,
    val gaps: String,
    val glutenFree: Boolean,
    val instructions: String,
    val lowFodmap: Boolean,
    val occasions: List<String>,
    val sustainable: Boolean,
    val vegan: Boolean,
    val vegetarian: Boolean,
    val veryHealthy: Boolean,
    val veryPopular: Boolean,
    val weightWatcherSmartPoints: BigDecimal,
    val dishTypes: List<String>,
    val extendedIngredients: Set<RecipeInformationExtendedIngredientsInner>,
)
