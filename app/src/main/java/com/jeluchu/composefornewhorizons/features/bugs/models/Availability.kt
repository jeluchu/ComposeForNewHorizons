package com.jeluchu.composefornewhorizons.features.bugs.models


import com.google.gson.annotations.SerializedName
import com.jeluchu.jchucomponentscompose.core.extensions.strings.empty

data class Availability(
    @SerializedName("isAllDay")
    val isAllDay: Boolean?,
    @SerializedName("isAllYear")
    val isAllYear: Boolean?,
    @SerializedName("location")
    val location: String?,
    @SerializedName("month-array-northern")
    val monthArrayNorthern: List<Int>?,
    @SerializedName("month-array-southern")
    val monthArraySouthern: List<Int>?,
    @SerializedName("month-northern")
    val monthNorthern: String?,
    @SerializedName("month-southern")
    val monthSouthern: String?,
    @SerializedName("rarity")
    val rarity: String?,
    @SerializedName("time")
    val time: String?,
    @SerializedName("time-array")
    val timeArray: List<Int>?
) {

    companion object {

        fun empty() = Availability(
            isAllDay = false,
            isAllYear = false,
            location = String.empty(),
            monthArrayNorthern = emptyList(),
            monthArraySouthern = emptyList(),
            monthNorthern = String.empty(),
            monthSouthern = String.empty(),
            rarity = String.empty(),
            time = String.empty(),
            timeArray = emptyList()
        )

    }

}