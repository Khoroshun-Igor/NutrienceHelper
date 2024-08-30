package com.tamago.spoonacularapi.models

import kotlinx.serialization.Serializable

@Serializable
data class WinePairingDto(
    val pairedWines: List<String>,
    val pairingText: String,
    val productMatches: Set<WinePairingProductMatcherDto>,
)
