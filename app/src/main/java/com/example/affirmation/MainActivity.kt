package com.example.affirmation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.affirmation.feature_assertion.presentation.component.AffirmationBoxCapsule
import com.example.affirmation.nav.SetupNavGraph
import com.example.affirmation.ui.theme.SaversTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            navController = rememberNavController()
            SetupNavGraph(navController)
        }
    }
}

@Composable
fun BoxScreen() {
    SaversTheme {
            AffirmationBoxCapsule(navHostController = rememberNavController())
    }
}

@Preview(showBackground = true)
@Composable
fun AffirmationBoxPreview() {
    SaversTheme {
        BoxScreen()
    }
}