package com.tamago.recipedata.model

import java.math.BigDecimal

/**
 * Created by Igor Khoroshun on 25.07.2024.
 */
public data class RecipeInformationExtendedIngredientsInner(
    val aisle: String,
    val amount: BigDecimal,
    val consistency: String,
    val id: Int,
    val image: String,
    val name: String,
    val original: String,
    val originalName: String,
    val unit: String
)
