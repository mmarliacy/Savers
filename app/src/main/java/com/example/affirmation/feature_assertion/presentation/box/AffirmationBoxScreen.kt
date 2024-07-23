package com.example.affirmation.feature_assertion.presentation.box


//noinspection UsingMaterialAndMaterial3Libraries
//noinspection UsingMaterialAndMaterial3Libraries
//noinspection UsingMaterialAndMaterial3Libraries
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavHostController
import com.example.affirmation.di.DataProvider
import com.example.affirmation.feature_assertion.domain.model.Affirmation

@Composable
fun AffirmationBoxScreen(innerpadding: PaddingValues, modifier: Modifier, navHostController: NavHostController) {
    val affirmationList = DataProvider().loadAffirmations()

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxSize()
        ) {
            AffirmationBoxCard(modifier = modifier, navHostController, affirmationList)
        }
}

@Composable
fun AffirmationBoxCard(modifier: Modifier, navHostController: NavHostController, list: List<Affirmation> ) {

    var index by remember{
        mutableIntStateOf(0)
    }

    var firstMessage by remember {
        mutableStateOf(list[index].stringAffirmation)
    }

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
                .clickable(onClick = {
                    if (index < list.size-1){
                        index = list.indices.random()
                        firstMessage = list[index].stringAffirmation
                    } else {
                        index = 0
                        firstMessage = list[index].stringAffirmation
                    }
                })
        ) {
            Box(
                modifier = modifier.padding(10.dp).clip(shape = RoundedCornerShape(5))
            ){
                Text(
                    text = firstMessage,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White,
                    modifier = modifier.padding(20.dp),
                    lineHeight = 2.em,
                    textAlign = TextAlign.Center,
                )
            }
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

