package com.jeluchu.composefornewhorizons.features.villagers.models


import com.google.gson.annotations.SerializedName
import com.jeluchu.composefornewhorizons.features.bugs.models.Availability
import com.jeluchu.composefornewhorizons.features.bugs.models.BugsItem
import com.jeluchu.composefornewhorizons.features.bugs.models.BugsItemEntity
import com.jeluchu.composefornewhorizons.features.bugs.models.Name
import com.jeluchu.jchucomponentscompose.core.extensions.ints.empty
import com.jeluchu.jchucomponentscompose.core.extensions.ints.orEmpty
import com.jeluchu.jchucomponentscompose.core.extensions.strings.empty

data class VillagerItem(
    val birthday: String,
    val birthdayString: String,
    val bubbleColor: String,
    val catchPhrase: String,
    val catchTranslations: CatchTranslations,
    val fileName: String,
    val gender: String,
    val hobby: String,
    val iconUri: String,
    val id: Int,
    val imageUri: String,
    val name: Name,
    val personality: String,
    val saying: String,
    val species: String,
    val subtype: String,
    val textColor: String
) {

    companion object {

        fun empty() = VillagerItem(
            birthday = String.empty(),
            birthdayString = String.empty(),
            bubbleColor = String.empty(),
            catchPhrase = String.empty(),
            catchTranslations = CatchTranslations.empty(),
            fileName = String.empty(),
            gender = String.empty(),
            hobby = String.empty(),
            iconUri = String.empty(),
            id = Int.empty(),
            imageUri = String.empty(),
            name = Name.empty(),
            personality = String.empty(),
            saying = String.empty(),
            species = String.empty(),
            subtype = String.empty(),
            textColor = String.empty()
        )

    }

}