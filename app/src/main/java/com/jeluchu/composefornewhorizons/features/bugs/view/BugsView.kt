package com.jeluchu.composefornewhorizons.features.bugs.view

import androidx.compose.animation.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.jeluchu.composefornewhorizons.core.navigation.Navigate
import com.jeluchu.composefornewhorizons.core.ui.theme.artichoke
import com.jeluchu.composefornewhorizons.core.ui.theme.cream
import com.jeluchu.composefornewhorizons.features.bugs.viewmodel.BugsViewModel
import com.jeluchu.jchucomponentscompose.ui.images.NetworkImage
import com.jeluchu.jchucomponentscompose.ui.modifier.cornerRadius

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BugsView(
    navigate: Navigate,
    vm: BugsViewModel = hiltViewModel()
) {

    // From here we will control and observe the status of our requests
    // communicated to us by the ViewModel
    val state by vm.state.collectAsState()

    val isShow = remember { mutableStateOf(false) }
    val density = LocalDensity.current

    // With Accompanist System UI Controller we can start customising
    // certain components of the system (Accompanist is a group of libraries
    // that contain commonly used elements but are still in an experimental phase)
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = MaterialTheme.colors.isLight

    SideEffect {
        // Update all of the system bar colors to be transparent, and use
        // dark icons if we're in light theme
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


    // Scaffold: Generic template with various components commonly used on Android screens
    Scaffold(

        // TopBar: In it we will introduce the Composable we want to show as Toolbar
        // at the top of the screen, if we do not customise any we can use
        // the default one called TopAppBar
        topBar = {
            TopAppBar(
                title = {
                    Text("TopAppBar")
                },
                backgroundColor = cream,
                elevation = 0.dp
            )
        },

        // FloatingButton: This will be the floating button that we will show at the bottom
        // right or left and where we can put different actions we want or
        // navigate to other screens
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { isShow.value = !isShow.value },
                backgroundColor = artichoke,
                elevation = FloatingActionButtonDefaults.elevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp
                )
            ) { Text("X") }
        },

        // DrawerContent: In this we will introduce the Composable we want to show
        // in the drop-down menu on the sides (in my opinion these types of menus are
        // less and less used every day)
        drawerContent = { Text(text = "DrawerContent") },

        // BottomBar: Normally used to implement a menu at the bottom with icons,
        // you can design a menu or put any kind of design inside this area
        bottomBar = {

            // With AnimatedVisibility we can hide a Composable by passing
            // a boolean from the visible parameter, we can even customise
            // the transition in and out
            AnimatedVisibility(
                visible = isShow.value,
                enter = slideInVertically {
                    with(density) { 40.dp.roundToPx() }
                } + expandVertically(
                    expandFrom = Alignment.Top
                ) + fadeIn(
                    initialAlpha = 0.3f
                ),
                exit = slideOutVertically{
                    with(density) { 40.dp.roundToPx() }
                } + shrinkVertically() + fadeOut()
            ) {
                BottomAppBar(
                    backgroundColor = cream
                ) { Text("BottomAppBar") }
            }

        },
        backgroundColor = cream
    ) {
        when{

            // Once our request has finished uploading and the data we have requested are not empty
            !state.isLoading && state.data.isNotEmpty() -> {

                // With LazyVerticalGrid we create a Grid list in which we can put several items
                // by columns, in this case we will put 2 cells so we will have, we indicate it
                // with GridCells.Fixed(2) or GridCells.Adaptive(20.dp)
                LazyVerticalGrid(
                    cells = GridCells.Fixed(2),
                    modifier = Modifier.padding(horizontal = 10.dp)
                ) {
                    items(state.data) { item ->

                        Column(
                            modifier = Modifier
                                .height(150.dp)
                                .padding(
                                    horizontal = 10.dp,
                                    vertical = 5.dp
                                )
                                .clip(RoundedCornerShape(16.dp))
                                .clickable { navigate.bugDetails(item.fileName) }
                                .background(artichoke.copy(.15f)),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            // NetworkImage is a custom component I have made that extends
                            // the Composable made in the Coil library
                            // (https://coil-kt.github.io/coil/compose/)
                            // compatible with Compose, and 100% in Kotlin with
                            // Coroutines compatibility
                            NetworkImage(
                                modifier = Modifier
                                    .size(80.dp)
                                    .clip(16.cornerRadius())
                                    .background(artichoke.copy(.3f)),
                                url = item.imageUri
                            )
                            
                            Text(
                                modifier = Modifier.padding(top = 10.dp),
                                text = item.name.nameEUen,
                                textAlign = TextAlign.Center,
                                maxLines = 1
                            )

                        }

                    }
                }

            }

            // Once our request has finished loading and the data we have requested
            // does not contain data due to some kind of error.
            !state.isLoading && state.data.isEmpty() -> {}

            // When our petition is in process and is still uploading
            state.isLoading -> {}

        }
    }

}