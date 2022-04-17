package com.jeluchu.composefornewhorizons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.jeluchu.composefornewhorizons.core.navigation.Navigation
import com.jeluchu.composefornewhorizons.core.ui.theme.ComposeForNewHorizonsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeForNewHorizonsTheme {
                Navigation()
            }
        }
    }
}