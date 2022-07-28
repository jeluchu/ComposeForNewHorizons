package com.jeluchu.composefornewhorizons.features.bugs.models


import com.google.gson.annotations.SerializedName
import com.jeluchu.jchucomponents.core.extensions.ints.empty
import com.jeluchu.jchucomponents.core.extensions.ints.orEmpty
import com.jeluchu.jchucomponents.core.extensions.strings.empty

data class BugsItemEntity(
    @SerializedName("alt-catch-phrase")
    val altCatchPhrase: List<String>?,
    @SerializedName("availability")
    val availability: Availability?,
    @SerializedName("catch-phrase")
    val catchPhrase: String?,
    @SerializedName("file-name")
    val fileName: String?,
    @SerializedName("icon_uri")
    val iconUri: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image_uri")
    val imageUri: String?,
    @SerializedName("museum-phrase")
    val museumPhrase: String?,
    @SerializedName("name")
    val name: NameEntity?,
    @SerializedName("price")
    val price: Int?,
    @SerializedName("price-flick")
    val priceFlick: Int?
) {

    fun toBugsItem() = BugsItem(
        altCatchPhrase = altCatchPhrase.orEmpty(),
        availability = availability ?: Availability.empty(),
        catchPhrase = catchPhrase.orEmpty(),
        name = name?.toName() ?: Name.empty(),
        fileName = fileName.orEmpty(),
        iconUri = iconUri.orEmpty(),
        id = id.orEmpty(),
        imageUri = imageUri.orEmpty(),
        museumPhrase = museumPhrase.orEmpty(),
        price = price.orEmpty(),
        priceFlick = priceFlick.orEmpty()
    )

    companion object {

        fun empty() = BugsItemEntity(
            altCatchPhrase = emptyList(),
            availability = Availability.empty(),
            catchPhrase = String.empty(),
            name = NameEntity.empty(),
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