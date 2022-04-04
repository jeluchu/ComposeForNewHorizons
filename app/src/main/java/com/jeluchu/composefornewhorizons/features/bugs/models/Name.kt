package com.jeluchu.composefornewhorizons.features.bugs.models

import com.google.gson.annotations.SerializedName

data class Name(
    @SerializedName("name-CNzh")
    val nameCNzh: String,
    @SerializedName("name-EUde")
    val nameEUde: String,
    @SerializedName("name-EUen")
    val nameEUen: String,
    @SerializedName("name-EUes")
    val nameEUes: String,
    @SerializedName("name-EUfr")
    val nameEUfr: String,
    @SerializedName("name-EUit")
    val nameEUit: String,
    @SerializedName("name-EUnl")
    val nameEUnl: String,
    @SerializedName("name-EUru")
    val nameEUru: String,
    @SerializedName("name-JPja")
    val nameJPja: String,
    @SerializedName("name-KRko")
    val nameKRko: String,
    @SerializedName("name-TWzh")
    val nameTWzh: String,
    @SerializedName("name-USen")
    val nameUSen: String,
    @SerializedName("name-USes")
    val nameUSes: String,
    @SerializedName("name-USfr")
    val nameUSfr: String
)