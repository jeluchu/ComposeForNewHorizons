package com.jeluchu.composefornewhorizons.features.villagers.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.jeluchu.composefornewhorizons.core.navigation.Navigate
import com.jeluchu.composefornewhorizons.core.ui.composables.CustomText
import com.jeluchu.composefornewhorizons.core.ui.theme.artichoke
import com.jeluchu.composefornewhorizons.core.ui.theme.cream
import com.jeluchu.composefornewhorizons.features.bugs.view.CustomItem
import com.jeluchu.composefornewhorizons.features.villagers.viewmodel.VillagersViewModel

@OptIn(
    ExperimentalFoundationApi::class,
    ExperimentalMaterialApi::class,
    ExperimentalMaterialApi::class,
    ExperimentalMaterialApi::class
)
@Composable
fun VillagersView(
    navigate: Navigate,
    vm: VillagersViewModel = hiltViewModel()
) {

    val state by vm.state.collectAsState()

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
            color = artichoke,
            darkIcons = useDarkIcons
        )

    }

    // Backdrop component is composed of 2 surfaces: back layer and front layer
    // In the back layer we will show the context including the AppBar,
    // and on the other hand, the front part will show the content based on our context
    BackdropScaffold(
        frontLayerBackgroundColor = cream,
        backLayerBackgroundColor = artichoke,
        appBar = {
            TopAppBar(
                title = { Text("Villagers") },
                contentColor = cream,
                backgroundColor = artichoke.copy(.5f),
                elevation = 0.dp,
                navigationIcon = {
                    IconButton(onClick = { navigate.goBack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = cream
                        )
                    }
                }
            )
        },
        backLayerContent = {
            Column() {

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
        },
        frontLayerContent = {
            when {
                !state.isLoading && state.data.isNotEmpty() -> {
                    LazyVerticalGrid(
                        cells = GridCells.Fixed(2),
                        modifier = Modifier.padding(horizontal =  10.dp)
                    ) {

                        items(state.data) { item ->

                            CustomItem(
                                id = item.fileName,
                                name = item.name.nameEUen,
                                image = item.imageUri,
                            )

                        }

                    }

                }
                !state.isLoading && state.data.isEmpty() -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(artichoke.copy(.5f))
                    ) {

                    }
                }
                state.isLoading -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(artichoke.copy(.5f))
                    ) {

                    }
                }

            }
        }
    )


}