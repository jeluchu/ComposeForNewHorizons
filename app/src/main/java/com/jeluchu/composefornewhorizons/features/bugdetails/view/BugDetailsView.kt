package com.jeluchu.composefornewhorizons.features.bugdetails.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.jeluchu.composefornewhorizons.core.navigation.Navigate
import com.jeluchu.composefornewhorizons.core.ui.theme.cream
import com.jeluchu.composefornewhorizons.features.bugs.models.BugsItem
import com.jeluchu.composefornewhorizons.features.bugs.viewmodel.BugsViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BugDetailsView(
    navigate: Navigate,
    vm: BugsViewModel = hiltViewModel(),
    bugId: String
) {

    val state by vm.state.collectAsState()
    val details = if (state.data.isNotEmpty())
        state.data.first { it.fileName == bugId }
    else BugsItem.empty()

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
        Text(
            modifier = Modifier.clickable { navigate.bugWeb(bugId, details.name.nameEUen) },
            text = "Id of Bug is: $bugId"
        )
    }

}