package com.jeluchu.composefornewhorizons.features.bugdetails.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.jeluchu.composefornewhorizons.core.ui.theme.textColor
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
        backgroundColor = cream,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .clickable { navigate.bugWeb(bugId, details.name.nameEUen) },
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
                color = textColor
            )

            if (snackbarVisibleState) {

                // Simple Snackbar
                Snackbar(
                    modifier = Modifier.padding(10.dp),
                    shape = RoundedCornerShape(16.dp),
                    elevation = 0.dp,
                    contentColor = Color.DarkGray,
                    backgroundColor = artichoke.copy(.2f)
                ) { Text(text = "The world is a Vampire!") }

                // Snackbar with action item
                Snackbar(
                    modifier = Modifier.padding(10.dp),
                    shape = RoundedCornerShape(16.dp),
                    elevation = 0.dp,
                    contentColor = Color.DarkGray,
                    backgroundColor = artichoke.copy(.2f),
                    action = {
                        TextButton(
                            onClick = { setSnackBarState(!snackbarVisibleState) }
                        ) {
                            Text(
                                text = "New Horizons",
                                color = textColor
                            )
                        }
                    }
                ) { Text(text = "Animal Crossing is the best game") }

                // Snackbar with action item below text
                Snackbar(
                    modifier = Modifier.padding(10.dp),
                    shape = RoundedCornerShape(16.dp),
                    elevation = 0.dp,
                    contentColor = Color.DarkGray,
                    backgroundColor = artichoke.copy(.2f),
                    actionOnNewLine = true,
                    action = {
                        TextButton(
                            onClick = { setSnackBarState(!snackbarVisibleState) }
                        ) {
                            Text(
                                modifier = Modifier.clickable { setSnackBarState(!snackbarVisibleState) },
                                text = "New Horizons",
                                color = textColor
                            )
                        }
                    }
                ) { Text(text = "Find many features on the iNook app") }

            }

        }
    }
}