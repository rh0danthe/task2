package com.example.task2.compose

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(
    val route: String,
    val navArguments: List<NamedNavArgument> = emptyList()
) {
    data object Home : Screen("home")

    data object ElementDetail : Screen(
        route = "elementDetail/{elementId}",
        navArguments = listOf(navArgument("elementId") {
            type = NavType.StringType
        })
    ) {
        fun createRoute(elementId: String) = "elementDetail/${elementId}"
    }
}