package com.jeluchu.composefornewhorizons.core.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.jeluchu.composefornewhorizons.features.bugdetails.view.BugDetailsView
import com.jeluchu.composefornewhorizons.features.bugs.view.BugsView
import com.jeluchu.composefornewhorizons.features.bugweb.view.BugWebView
import com.jeluchu.jchucomponentscompose.core.extensions.strings.empty

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Navigation(
    navController: NavHostController = rememberAnimatedNavController()
) {

    val navigate = remember(navController) { Navigate(navController) }

    // With the compose navigation library we will have NavHost,
    // but if we include Accompanist's animated navigation, we can have transition
    // animations both in and out between Composable and Composable,
    // default or custom animations
    AnimatedNavHost(
        navController = navController,
        startDestination = NavItem.Bugs.baseRoute
    ) {

        // We declare our composable inside the navigation graph,
        // and we pass as parameters the path and the arguments,
        // in case we want to pass an argument between one composable and another,
        // and we indicate which composable should navigate with that route

        composable(
            route = NavItem.Bugs.route
        ) { BugsView(navigate = navigate) }

        composable(
            route = NavItem.BugDetails.route,
            arguments = NavItem.BugDetails.args
        ) { BugDetailsView(navigate = navigate) }

        composable(
            route = NavItem.BugWeb.route,
            arguments = NavItem.BugWeb.args
        ) { navBackStackEntry ->
            BugWebView(
                navigate = navigate,
                bugId = navBackStackEntry.arguments?.getString(NavArgs.BugId.key) ?: String.empty(),
                bugName = navBackStackEntry.arguments?.getString(NavArgs.BugName.key)
                    ?: String.empty()
            )
        }

    }

}