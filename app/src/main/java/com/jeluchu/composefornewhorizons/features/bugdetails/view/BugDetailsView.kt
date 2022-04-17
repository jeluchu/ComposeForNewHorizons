package com.jeluchu.composefornewhorizons.features.bugdetails.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.jeluchu.composefornewhorizons.core.navigation.Navigate
import com.jeluchu.composefornewhorizons.core.ui.theme.artichoke
import com.jeluchu.composefornewhorizons.core.ui.theme.cream
import com.jeluchu.composefornewhorizons.features.bugs.models.BugsItem
import com.jeluchu.composefornewhorizons.features.bugs.viewmodel.BugsViewModel
import com.jeluchu.jchucomponentscompose.ui.modifier.cornerRadius

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

    val (snackbarVisibleState, setSnackBarState) = remember { mutableStateOf(false) }

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
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                modifier = Modifier.clickable { navigate.bugWeb(bugId, details.name.nameEUen) },
                text = "Id of Bug is: $bugId"
            )

            Text(
                text = "Show Snackbar",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 10.dp,
                        end = 10.dp,
                        bottom = 10.dp
                    )
                    .clip(13.cornerRadius())
                    .clickable { setSnackBarState(!snackbarVisibleState) }
                    .background(artichoke.copy(.2f))
                    .padding(5.dp),
                textAlign = TextAlign.Center,
                color = artichoke
            )

            if (snackbarVisibleState) {
                Snackbar(
                    action = {
                        Button(onClick = { setSnackBarState(!snackbarVisibleState) }) {
                            Text("Go to Work!")
                        }
                    },
                    modifier = Modifier.padding(8.dp)
                ) { Text(text = "The world is a Vampire!") }
            }

        }
    }
}