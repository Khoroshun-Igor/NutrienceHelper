package com.tamago.domain.model

import java.math.BigDecimal

data class WinePairingProductMatcherUI(
    val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val imageUrl: String,
    val averageRating: BigDecimal,
    val ratingCount: Int,
    val score: BigDecimal,
    val link: String,
)
