package com.example.todocompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import com.example.todocompose.navigation.destinations.listComposable
import com.example.todocompose.navigation.destinations.taskComposable
import com.example.todocompose.ui.viewModels.SharedViewModel
import com.example.todocompose.util.Constants.LIST_SCREEN

@Composable
fun Navigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(
        navController = navController,
        startDestination = LIST_SCREEN
    ) {
        listComposable(
            navigateToTaskScreen = screen.task,
            sharedViewModel = sharedViewModel
        )

        taskComposable(
            navigateToListScreen = screen.list
        )
    }
}