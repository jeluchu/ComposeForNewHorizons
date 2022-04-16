package com.jeluchu.composefornewhorizons.features.bugs.view

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jeluchu.composefornewhorizons.core.ui.theme.artichoke
import com.jeluchu.composefornewhorizons.core.ui.theme.cream
import com.jeluchu.composefornewhorizons.features.bugs.viewmodel.BugsViewModel

@Composable
fun BugsView(
    vm: BugsViewModel = hiltViewModel()
) {

    // From here we will control and observe the status of our requests
    // communicated to us by the ViewModel
    val state by vm.state.collectAsState()

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
                onClick = {},
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
            BottomAppBar(
                backgroundColor = cream
            ) { Text("BottomAppBar") }
        }
    ) {
        when{

            // Once our request has finished uploading and the data we have requested are not empty
            !state.isLoading && state.data.isNotEmpty() -> {}

            // Once our request has finished loading and the data we have requested
            // does not contain data due to some kind of error.
            !state.isLoading && state.data.isEmpty() -> {}

            // When our petition is in process and is still uploading
            state.isLoading -> {}

        }
    }

}