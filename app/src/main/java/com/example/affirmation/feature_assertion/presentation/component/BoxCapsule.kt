package com.example.affirmation.feature_assertion.presentation.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.affirmation.feature_assertion.presentation.box.AffirmationBoxScreen
import com.example.affirmation.nav.AffirmationRoute


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AffirmationBoxCapsule(navHostController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                actions = {
                    IconButton(onClick = { /*do something*/ }) {
                        Icon(
                            Icons.Filled.Build,
                            contentDescription = "Change color of screen"
                        )
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(Icons.Filled.Check, contentDescription = "Localized description")
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            Icons.Filled.Create,
                            contentDescription = "Change appearance of text"
                        )
                    }

                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = {
                            navHostController.navigate(route = AffirmationRoute.AffirmationsList.route)
                        },
                        containerColor = Color.Black,
                        contentColor = Color.White
                    ) {
                        Icon(
                            Icons.Filled.MoreVert,
                            contentDescription = "Access to Affirmation list"
                        )
                    }
                }

            )
        },
        ) { innerPadding ->
        AffirmationBoxScreen(innerPadding, modifier = Modifier, navHostController = rememberNavController())
    }

}