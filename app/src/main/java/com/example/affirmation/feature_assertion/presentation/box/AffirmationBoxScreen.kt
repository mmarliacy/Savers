package com.example.affirmation.feature_assertion.presentation.box


//noinspection UsingMaterialAndMaterial3Libraries
//noinspection UsingMaterialAndMaterial3Libraries
//noinspection UsingMaterialAndMaterial3Libraries
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavHostController
import com.example.affirmation.nav.AffirmationRoute

@Composable
fun AffirmationBoxScreen(affirmation: String, modifier: Modifier, navHostController: NavHostController) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxSize()
        ) {
            AffirmationBoxCard(affirmation = affirmation, modifier = modifier.padding(it), navHostController)
        }
    }


}

@Composable
fun AffirmationBoxCard(affirmation: String, modifier: Modifier, navHostController: NavHostController) {
    Surface(
        shape = RoundedCornerShape(20.dp),
        color = Color.Black,
        shadowElevation = 4.dp,
        modifier = modifier
            .padding(10.dp)
            .fillMaxSize()
    ) {
        Box(
            contentAlignment = Alignment.Center, modifier = modifier
                .clickable(true, onClick = {
                })
        ) {
            Text(
                text = affirmation,
                style = MaterialTheme.typography.titleMedium,
                color = Color.White,
                modifier = modifier.padding(20.dp),
                lineHeight = 2.em,
                textAlign = TextAlign.Center
            )
        }
        Row(horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom,
            modifier = modifier
                .padding(20.dp)
                .padding(bottom = 20.dp)
        ){
            Button(
                colors = ButtonColors(Color.White, Color.Black, Color.Red, Color.Black),
                modifier = modifier.fillMaxWidth(),
                enabled = true,
                onClick = {
                    navHostController.navigate(route = AffirmationRoute.AffirmationsList.route)
                }) {

                Text(
                    text = "Mes affirmations",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = modifier.padding(10.dp)
                )
            }
        }
    }
}

