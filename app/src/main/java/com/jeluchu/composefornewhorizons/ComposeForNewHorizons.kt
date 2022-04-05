package com.jeluchu.composefornewhorizons

import android.content.Context
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ComposeForNewHorizons : MultiDexApplication() {

    init {
        instance = this
    }

    companion object {

        var instance: ComposeForNewHorizons? = null

        private val context: ComposeForNewHorizons
            get() = instance as ComposeForNewHorizons

        fun getContext(): Context = context

    }
}