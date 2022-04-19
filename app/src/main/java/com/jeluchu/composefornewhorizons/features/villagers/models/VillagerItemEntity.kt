package com.jeluchu.composefornewhorizons.features.villagers.models

import com.google.gson.annotations.SerializedName
import com.jeluchu.composefornewhorizons.features.bugs.models.Name
import com.jeluchu.jchucomponentscompose.core.extensions.ints.empty
import com.jeluchu.jchucomponentscompose.core.extensions.ints.orEmpty
import com.jeluchu.jchucomponentscompose.core.extensions.strings.empty

data class VillagerItemEntity(
    @SerializedName("birthday")
    val birthday: String?,
    @SerializedName("birthday-string")
    val birthdayString: String?,
    @SerializedName("bubble-color")
    val bubbleColor: String?,
    @SerializedName("catch-phrase")
    val catchPhrase: String?,
    @SerializedName("catch-translations")
    val catchTranslations: CatchTranslationsEntity?,
    @SerializedName("file-name")
    val fileName: String?,
    @SerializedName("gender")
    val gender: String?,
    @SerializedName("hobby")
    val hobby: String?,
    @SerializedName("icon_uri")
    val iconUri: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image_uri")
    val imageUri: String?,
    @SerializedName("name")
    val name: NameEntity?,
    @SerializedName("personality")
    val personality: String?,
    @SerializedName("saying")
    val saying: String?,
    @SerializedName("species")
    val species: String?,
    @SerializedName("subtype")
    val subtype: String?,
    @SerializedName("text-color")
    val textColor: String?
) {

    fun toVillagerItem() = VillagerItem(
        birthday = birthday.orEmpty(),
        birthdayString = birthdayString.orEmpty(),
        bubbleColor = bubbleColor.orEmpty(),
        catchPhrase = catchPhrase.orEmpty(),
        catchTranslations = catchTranslations?.toCatchTranslations() ?: CatchTranslations.empty(),
        fileName = fileName.orEmpty(),
        gender = gender.orEmpty(),
        hobby = hobby.orEmpty(),
        iconUri = iconUri.orEmpty(),
        id = id.orEmpty(),
        imageUri = imageUri.orEmpty(),
        name = name?.toName() ?: Name.empty(),
        personality = personality.orEmpty(),
        saying = saying.orEmpty(),
        species = species.orEmpty(),
        subtype = subtype.orEmpty(),
        textColor = textColor.orEmpty()
    )

    companion object {

        fun empty() = VillagerItemEntity(
            birthday = String.empty(),
            birthdayString = String.empty(),
            bubbleColor = String.empty(),
            catchPhrase = String.empty(),
            catchTranslations = CatchTranslationsEntity.empty(),
            fileName = String.empty(),
            gender = String.empty(),
            hobby = String.empty(),
            iconUri = String.empty(),
            id = Int.empty(),
            imageUri = String.empty(),
            name = NameEntity.empty(),
            personality = String.empty(),
            saying = String.empty(),
            species = String.empty(),
            subtype = String.empty(),
            textColor = String.empty()
        )

    }

}