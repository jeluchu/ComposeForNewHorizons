package com.jeluchu.composefornewhorizons.features.bugdetails.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.jeluchu.composefornewhorizons.core.navigation.Navigate
import com.jeluchu.composefornewhorizons.core.ui.composables.CustomText
import com.jeluchu.composefornewhorizons.core.ui.theme.artichoke
import com.jeluchu.composefornewhorizons.core.ui.theme.cream
import com.jeluchu.composefornewhorizons.core.ui.theme.textColor
import com.jeluchu.composefornewhorizons.features.bugdetails.viewmodel.BugDetailViewModel
import com.jeluchu.jchucomponentscompose.ui.modifier.cornerRadius
import kotlinx.coroutines.launch

@OptIn(
    ExperimentalFoundationApi::class,
    ExperimentalMaterialApi::class
)
@Composable
fun BugDetailsView(
    navigate: Navigate,
    vm: BugDetailViewModel = hiltViewModel()
) {

    val state by vm.state.collectAsState()
    val details = state.data

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

    val scope = rememberCoroutineScope()
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(
            initialValue = BottomSheetValue.Collapsed
        )
    )
    val bottomSheetState = bottomSheetScaffoldState.bottomSheetState

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetBackgroundColor = artichoke,
        sheetShape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
        sheetContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        modifier = Modifier
                            .size(50.dp)
                            .weight(1f)
                            .padding(bottom = 10.dp),
                        imageVector = ImageVector.vectorResource(id = com.jeluchu.composefornewhorizons.R.drawable.ic_deco_leaf),
                        tint = cream,
                        contentDescription = "Leaf"
                    )

                    CustomText(
                        modifier = Modifier
                            .weight(4f)
                            .padding(
                                top = 10.dp,
                            start = 10.dp,
                            end = 10.dp,
                            bottom = 20.dp
                        ),
                        title = if (bottomSheetState.isExpanded) "Hide BottomSheetScaffold"
                        else "Show BottomSheetScaffold",
                        bgColor = cream,
                        onClick = {
                            scope.launch {
                                if (bottomSheetState.isExpanded) bottomSheetState.collapse()
                                else bottomSheetState.expand()
                            }
                        }
                    )

                }

                CustomText(
                    modifier = Modifier.padding(
                        start = 10.dp,
                        end = 10.dp,
                        bottom = 10.dp
                    ),
                    title = "Test 1",
                    bgColor = cream
                )

                CustomText(
                    modifier = Modifier.padding(
                        start = 10.dp,
                        end = 10.dp,
                        bottom = 10.dp
                    ),
                    title = "Test 2",
                    bgColor = cream
                )

                CustomText(
                    modifier = Modifier.padding(
                        start = 10.dp,
                        end = 10.dp,
                        bottom = 10.dp
                    ),
                    title = "Test 3",
                    bgColor = cream
                )

            }
        }
    ) {

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
                        .clickable { navigate.bugWeb(details.fileName, details.name.nameEUen) },
                    text = "Id of Bug is: ${details.fileName}"
                )

                CustomText(
                    modifier = Modifier.padding(
                        start = 10.dp,
                        end = 10.dp,
                        bottom = 10.dp
                    ),
                    title = "Show Tabs",
                    onClick = navigate.bugTabs
                )

                CustomText(
                    modifier = Modifier.padding(
                        start = 10.dp,
                        end = 10.dp,
                        bottom = 10.dp
                    ),
                    title = "Show Snackbar",
                    onClick = { setSnackBarState(!snackbarVisibleState) }
                )

                CustomText(
                    modifier = Modifier.padding(
                        start = 10.dp,
                        end = 10.dp,
                        bottom = 10.dp
                    ),
                    title = "Show BackdropScaffold",
                    onClick = navigate.villagers
                )

                CustomText(
                    modifier = Modifier.padding(
                        start = 10.dp,
                        end = 10.dp,
                        bottom = 10.dp
                    ),
                    title = "Show BottomSheetScaffold",
                    onClick = {
                        scope.launch {
                            if (bottomSheetState.isExpanded) bottomSheetState.collapse()
                            else bottomSheetState.expand()
                        }
                    }
                )

                AnimatedVisibility(visible = snackbarVisibleState) {
                    Column {

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

                LazyRow(verticalAlignment = Alignment.CenterVertically) {

                    item{
                        CustomText(
                            modifier = Modifier.padding(start = 10.dp),
                            title = "Show Tabs",
                            onClick = navigate.bugTabs
                        )
                    }

                    items(details.availability.timeArray.orEmpty()) { item ->

                        if (item == 4)
                            Text(
                                text = "Available at: $item",
                                modifier = Modifier
                                    .padding(10.dp)
                                    .padding(5.dp),
                                textAlign = TextAlign.Center,
                                color = textColor
                            )
                        else
                            Text(
                                text = "Available at: $item",
                                modifier = Modifier
                                    .padding(10.dp)
                                    .clip(13.cornerRadius())
                                    .background(artichoke.copy(.2f))
                                    .padding(8.dp),
                                textAlign = TextAlign.Center,
                                color = textColor
                            )

                    }

                }

            }
        }

    }


}