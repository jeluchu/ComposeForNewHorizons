package com.jeluchu.composefornewhorizons.features.bugs.models

data class BugsItem(
    val altCatchPhrase: List<String>,
    val availability: Availability,
    val catchPhrase: String,
    val fileName: String,
    val iconUri: String,
    val id: Int,
    val imageUri: String,
    val museumPhrase: String,
    val name: Name,
    val price: Int,
    val priceFlick: Int
)