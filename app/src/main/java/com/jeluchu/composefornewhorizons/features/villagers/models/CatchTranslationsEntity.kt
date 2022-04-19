package com.jeluchu.composefornewhorizons.features.villagers.models

import com.google.gson.annotations.SerializedName
import com.jeluchu.composefornewhorizons.features.bugs.models.Name
import com.jeluchu.jchucomponentscompose.core.extensions.strings.empty

data class CatchTranslationsEntity(
    @SerializedName("catch-CNzh")
    val catchCNzh: String?,
    @SerializedName("catch-EUde")
    val catchEUde: String?,
    @SerializedName("catch-EUen")
    val catchEUen: String?,
    @SerializedName("catch-EUes")
    val catchEUes: String?,
    @SerializedName("catch-EUfr")
    val catchEUfr: String?,
    @SerializedName("catch-EUit")
    val catchEUit: String?,
    @SerializedName("catch-EUnl")
    val catchEUnl: String?,
    @SerializedName("catch-EUru")
    val catchEUru: String?,
    @SerializedName("catch-JPja")
    val catchJPja: String?,
    @SerializedName("catch-KRko")
    val catchKRko: String?,
    @SerializedName("catch-TWzh")
    val catchTWzh: String?,
    @SerializedName("catch-USen")
    val catchUSen: String?,
    @SerializedName("catch-USes")
    val catchUSes: String?,
    @SerializedName("catch-USfr")
    val catchUSfr: String?
) {

    fun toCatchTranslations() = CatchTranslations(
        catchCNzh = catchCNzh.orEmpty(),
        catchEUde = catchEUde.orEmpty(),
        catchEUen = catchEUen.orEmpty(),
        catchEUes = catchEUes.orEmpty(),
        catchEUfr = catchEUfr.orEmpty(),
        catchEUit = catchEUit.orEmpty(),
        catchEUnl = catchEUnl.orEmpty(),
        catchEUru = catchEUru.orEmpty(),
        catchJPja = catchJPja.orEmpty(),
        catchKRko = catchKRko.orEmpty(),
        catchTWzh = catchTWzh.orEmpty(),
        catchUSen = catchUSen.orEmpty(),
        catchUSes = catchUSes.orEmpty(),
        catchUSfr = catchUSfr.orEmpty()
    )

    companion object {

        fun empty() = CatchTranslationsEntity(
            catchCNzh = String.empty(),
            catchEUde = String.empty(),
            catchEUen = String.empty(),
            catchEUes = String.empty(),
            catchEUfr = String.empty(),
            catchEUit = String.empty(),
            catchEUnl = String.empty(),
            catchEUru = String.empty(),
            catchJPja = String.empty(),
            catchKRko = String.empty(),
            catchTWzh = String.empty(),
            catchUSen = String.empty(),
            catchUSes = String.empty(),
            catchUSfr = String.empty()
        )

    }

}