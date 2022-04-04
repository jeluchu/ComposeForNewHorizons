package com.jeluchu.composefornewhorizons.features.bugs.models


import com.google.gson.annotations.SerializedName

data class Availability(
    @SerializedName("isAllDay")
    val isAllDay: Boolean,
    @SerializedName("isAllYear")
    val isAllYear: Boolean,
    @SerializedName("location")
    val location: String,
    @SerializedName("month-array-northern")
    val monthArrayNorthern: List<Int>,
    @SerializedName("month-array-southern")
    val monthArraySouthern: List<Int>,
    @SerializedName("month-northern")
    val monthNorthern: String,
    @SerializedName("month-southern")
    val monthSouthern: String,
    @SerializedName("rarity")
    val rarity: String,
    @SerializedName("time")
    val time: String,
    @SerializedName("time-array")
    val timeArray: List<Int>
)