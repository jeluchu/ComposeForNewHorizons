package com.jeluchu.composefornewhorizons.features.bugdetails.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.jeluchu.composefornewhorizons.core.navigation.Navigate
import com.jeluchu.composefornewhorizons.core.ui.theme.cream

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BugDetailsView(
    navigate: Navigate,
    bugId: String
) {

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = MaterialTheme.colors.isLight

    SideEffect {

        systemUiController.setSystemBarsColor(
            color = cream,
            darkIcons = useDarkIcons
        )

        systemUiController.setNavigationBarColor(
            color = cream,
            darkIcons = useDarkIcons
        )

        systemUiController.setStatusBarColor(
            color = cream,
            darkIcons = useDarkIcons
        )

    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("TopAppBar")
                },
                navigationIcon = {
                    IconButton(onClick = { navigate.goBack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.DarkGray
                        )
                    }
                },
                backgroundColor = cream,
                elevation = 0.dp
            )
        },
        backgroundColor = cream
    ) {
        Text(text = "Id of Bug is: $bugId")
    }

}