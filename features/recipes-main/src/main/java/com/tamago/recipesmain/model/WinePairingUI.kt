package com.tamago.recipesmain.model

data class WinePairingUI(
    val pairedWines: List<String>,
    val pairingText: String,
    val productMatches: Set<WinePairingProductMatcherUI>
)
