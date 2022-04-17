package com.jeluchu.composefornewhorizons.core.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

// NavItem is a sealed class in which we will have the base route
// and the list of arguments (by default an empty list),
// in which we will include the different screens we will navigate to
sealed class NavItem(
    val baseRoute: String,
    private val navArgs: List<NavArgs> = emptyList()
) {

    val route = run {
        val argKeys = navArgs.map { "{${it.key}}" }
        listOf(baseRoute)
            .plus(argKeys)
            .joinToString("/")
    }

    val args = navArgs.map {
        navArgument(it.key) { type = it.navType }
    }

    object Bugs : NavItem("bugs")
    object BugDetails : NavItem("bugDetails", listOf(NavArgs.BugId)) {
        fun createNavRoute(bugId: String) = "$baseRoute/$bugId"
    }

    object BugWeb : NavItem("bugWeb", listOf(NavArgs.BugId, NavArgs.BugName)) {
        fun createNavRoute(bugId: String, bugName: String) = "$baseRoute/$bugId/$bugName"
    }

}

// In NavArgs we will include all the types of arguments
// that we will later include in our NavItem and in which
// we will have the key of each argument and its type
enum class NavArgs(
    val key: String,
    val navType: NavType<*>
) {
    BugId(key = "bugId", navType = NavType.StringType),
    BugName(key = "bugName", navType = NavType.StringType)
}