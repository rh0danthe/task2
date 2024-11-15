package com.example.task2.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import android.app.Activity
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.task2.compose.elementdetail.ElementDetailsScreen
import com.example.task2.compose.home.HomeScreen
import com.example.task2.viewmodels.ElementViewModel

@Composable
fun Task2App(viewModel: ElementViewModel) {
    val navController = rememberNavController()
    Task2NavHost(
        viewModel = viewModel,
        navController = navController
    )
}

@Composable
fun Task2NavHost(
    viewModel: ElementViewModel,
    navController: NavHostController
) {
    val activity = (LocalContext.current as Activity)
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(
                viewModel = viewModel,
                onElemClick = {
                    navController.navigate(
                        Screen.ElementDetail.createRoute(
                            elementId = it.id
                        )
                    )
                }
            )
        }
        composable(
            route = Screen.ElementDetail.route,
            arguments = Screen.ElementDetail.navArguments
        ){ backStackEntry ->
            val elementId = backStackEntry.arguments?.getString("elementId")
            ElementDetailsScreen(
                viewModel = viewModel,
                elementId = elementId ?: "-1",
                onBackClick = { navController.navigateUp() }
            )
        }
    }
}