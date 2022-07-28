package com.jeluchu.composefornewhorizons.features.villagers.models

import com.jeluchu.composefornewhorizons.features.bugs.models.Name
import com.jeluchu.jchucomponents.core.extensions.strings.empty

data class CatchTranslations(
    val catchCNzh: String,
    val catchEUde: String,
    val catchEUen: String,
    val catchEUes: String,
    val catchEUfr: String,
    val catchEUit: String,
    val catchEUnl: String,
    val catchEUru: String,
    val catchJPja: String,
    val catchKRko: String,
    val catchTWzh: String,
    val catchUSen: String,
    val catchUSes: String,
    val catchUSfr: String
) {

    companion object {

        fun empty() = CatchTranslations(
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