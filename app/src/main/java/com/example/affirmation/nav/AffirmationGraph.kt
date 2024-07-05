package com.example.affirmation.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.affirmation.BoxScreen
import com.example.affirmation.ListScreen

@Composable
fun SetupNavGraph(
    navHostController: NavHostController
) {

    NavHost(
        navController = navHostController,
        startDestination = AffirmationRoute.AffirmationBox.route

    ) {
        composable(
            route = AffirmationRoute.AffirmationBox.route
        ){
            BoxScreen(navHostController = navHostController)
        }
        composable(
            route = AffirmationRoute.AffirmationsList.route
        ){
            ListScreen()        }
    }
}