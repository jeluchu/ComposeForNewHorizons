package com.jeluchu.composefornewhorizons.core.navigation

import androidx.navigation.NavHostController

// The Navigate class will allow us to navigate between screens
// in a more efficient way and with very little code, in it we will
// include all the accesses to which we have planned to navigate
class Navigate(navController: NavHostController) {

    val goBack: () -> Unit = { navController.popBackStack() }
    val bugDetails: (String) -> Unit = { id ->
        navController.navigate(NavItem.BugDetails.createNavRoute(id))
    }
    val bugWeb: (String, String) -> Unit = { id, name ->
        navController.navigate(NavItem.BugWeb.createNavRoute(id, name))
    }

    val bugTabs: () -> Unit = { navController.navigate(NavItem.BugTabs.route) }

}