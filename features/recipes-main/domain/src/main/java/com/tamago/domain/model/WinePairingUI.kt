package com.tamago.domain.model

data class WinePairingUI(
    val pairedWines: List<String>,
    val pairingText: String,
    val productMatches: Set<WinePairingProductMatcherUI>
)
