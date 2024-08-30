package com.tamago.domain.model

import java.math.BigDecimal

data class RecipeInformationExtendedIngredientsInnerUI(
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
