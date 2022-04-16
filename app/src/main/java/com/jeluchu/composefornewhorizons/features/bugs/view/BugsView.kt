package com.jeluchu.composefornewhorizons.features.bugs.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.jeluchu.composefornewhorizons.features.bugs.viewmodel.BugsViewModel

@Composable
fun BugsView(
    vm: BugsViewModel = hiltViewModel()
) {

    val state by vm.state.collectAsState()

}