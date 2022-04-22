package com.jeluchu.composefornewhorizons.features.villagers.models


import com.google.gson.annotations.SerializedName
import com.jeluchu.composefornewhorizons.features.bugs.models.Name
import com.jeluchu.jchucomponentscompose.core.extensions.ints.orEmpty
import com.jeluchu.jchucomponentscompose.core.extensions.strings.empty

data class NameEntity(
    @SerializedName("name-CNzh")
    val nameCNzh: String?,
    @SerializedName("name-EUde")
    val nameEUde: String?,
    @SerializedName("name-EUen")
    val nameEUen: String?,
    @SerializedName("name-EUes")
    val nameEUes: String?,
    @SerializedName("name-EUfr")
    val nameEUfr: String?,
    @SerializedName("name-EUit")
    val nameEUit: String?,
    @SerializedName("name-EUnl")
    val nameEUnl: String?,
    @SerializedName("name-EUru")
    val nameEUru: String?,
    @SerializedName("name-JPja")
    val nameJPja: String?,
    @SerializedName("name-KRko")
    val nameKRko: String?,
    @SerializedName("name-TWzh")
    val nameTWzh: String?,
    @SerializedName("name-USen")
    val nameUSen: String?,
    @SerializedName("name-USes")
    val nameUSes: String?,
    @SerializedName("name-USfr")
    val nameUSfr: String?
) {

    fun toName() = Name(
        nameCNzh = nameCNzh.orEmpty(),
        nameEUde = nameEUde.orEmpty(),
        nameEUen = nameEUen.orEmpty(),
        nameEUes = nameEUes.orEmpty(),
        nameEUfr = nameEUfr.orEmpty(),
        nameEUit = nameEUit.orEmpty(),
        nameEUnl = nameEUnl.orEmpty(),
        nameEUru = nameEUru.orEmpty(),
        nameJPja = nameJPja.orEmpty(),
        nameKRko = nameKRko.orEmpty(),
        nameTWzh = nameTWzh.orEmpty(),
        nameUSen = nameUSen.orEmpty(),
        nameUSes = nameUSes.orEmpty(),
        nameUSfr = nameUSfr.orEmpty()
    )

    companion object {

        fun empty() = NameEntity(
            nameCNzh = String.empty(),
            nameEUde = String.empty(),
            nameEUen = String.empty(),
            nameEUes = String.empty(),
            nameEUfr = String.empty(),
            nameEUit = String.empty(),
            nameEUnl = String.empty(),
            nameEUru = String.empty(),
            nameJPja = String.empty(),
            nameKRko = String.empty(),
            nameTWzh = String.empty(),
            nameUSen = String.empty(),
            nameUSes = String.empty(),
            nameUSfr = String.empty()
        )

    }

}