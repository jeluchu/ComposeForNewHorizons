package com.jeluchu.composefornewhorizons.features.villagers.models

import com.jeluchu.jchucomponents.core.extensions.strings.empty

data class Name(
    val nameCNzh: String,
    val nameEUde: String,
    val nameEUen: String,
    val nameEUes: String,
    val nameEUfr: String,
    val nameEUit: String,
    val nameEUnl: String,
    val nameEUru: String,
    val nameJPja: String,
    val nameKRko: String,
    val nameTWzh: String,
    val nameUSen: String,
    val nameUSes: String,
    val nameUSfr: String
) {

    companion object {

        fun empty() = Name(
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