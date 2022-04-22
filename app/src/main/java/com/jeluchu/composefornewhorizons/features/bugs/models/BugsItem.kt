package com.jeluchu.composefornewhorizons.features.bugs.models

import com.jeluchu.jchucomponentscompose.core.extensions.ints.empty
import com.jeluchu.jchucomponentscompose.core.extensions.strings.empty

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
) {

    companion object {

        fun empty() = BugsItem(
            altCatchPhrase = emptyList(),
            availability = Availability.empty(),
            catchPhrase = String.empty(),
            name = Name.empty(),
            fileName = String.empty(),
            iconUri = String.empty(),
            id = Int.empty(),
            imageUri = String.empty(),
            museumPhrase = String.empty(),
            price = Int.empty(),
            priceFlick = Int.empty()
        )

    }

}