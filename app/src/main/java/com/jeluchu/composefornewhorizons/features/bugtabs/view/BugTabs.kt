package com.jeluchu.composefornewhorizons.features.bugtabs.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.jeluchu.composefornewhorizons.core.navigation.Navigate
import com.jeluchu.composefornewhorizons.core.ui.composables.CustomText
import com.jeluchu.composefornewhorizons.core.ui.theme.artichoke
import com.jeluchu.composefornewhorizons.core.ui.theme.cream
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BugTabs(
    navigate: Navigate
) {

    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState()
    val tabs =
        listOf("iNook", "Nookphone", "Critterpedia", "Passport", "Happy Home Network", "Museum")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tabs") },
                backgroundColor = cream,
                elevation = 0.dp,
                navigationIcon = {
                    IconButton(onClick = { navigate.goBack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.DarkGray
                        )
                    }
                }
            )
        },
    ) {

        Column {

            // If we want to include Tabs with scroll to manage our HorizontalPager,
            // we can use ScrollableTabRow, in which we will pass our list of tabs
            // and pass them in a custom Composable
            ScrollableTabRow(
                modifier = Modifier.fillMaxWidth(),
                selectedTabIndex = pagerState.currentPage,
                backgroundColor = cream,
                contentColor = Color.White,
                edgePadding = 0.dp,
                indicator = {}
            ) {
                tabs.forEachIndexed { index, tab ->

                    // Customized compostable for our Tab
                    CustomText(
                        modifier = Modifier.padding(
                            start = 10.dp,
                            end = 10.dp,
                            bottom = 10.dp
                        ),
                        title = tab,
                        bgColor = if (pagerState.currentPage == index) artichoke.copy(.2f)
                        else Color.Transparent,
                        onClick = {
                            scope.launch {

                                // Navigate to another Tab with animation to visualize
                                // the rest of the screens included in HorizontalPager
                                pagerState.animateScrollToPage(index)

                            }
                        }
                    )

                }
            }

            // With HorizontalPager we have a similar behavior to ViewPager (XML)
            // there is the horizontal option, but there is also VerticalPager
            // for vertical option, and in it we will include the screens we want
            // to show according to the page we are in
            HorizontalPager(
                modifier = Modifier.fillMaxSize(),
                count = tabs.size,

                // It is important to include pagerState to synchronize with
                // the ScrollableTabRow or to perform other actions
                state = pagerState

            ) { page ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(cream),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Icon(
                        modifier = Modifier
                            .size(80.dp)
                            .padding(bottom = 10.dp),
                        imageVector = ImageVector.vectorResource(id = com.jeluchu.composefornewhorizons.R.drawable.ic_deco_leaf),
                        tint = artichoke,
                        contentDescription = "Leaf"
                    )

                    Text(text = "This page is ${tabs[page]}")

                }

            }

        }

    }

}