package com.jeluchu.composefornewhorizons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.jeluchu.composefornewhorizons.core.navigation.Navigation
import com.jeluchu.composefornewhorizons.core.ui.theme.ComposeForNewHorizonsTheme
import com.jeluchu.jchucomponentscompose.ui.animations.SplashAnimations
import com.jeluchu.jchucomponentscompose.ui.animations.SplashScreenController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SplashScreenController(installSplashScreen()).apply {
            customizeSplashScreenExit(listOf(SplashAnimations.SlideUp))
        }

        setContent { ComposeForNewHorizonsTheme { Navigation() } }

    }

}