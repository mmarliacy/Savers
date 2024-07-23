package com.example.affirmation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.affirmation.di.DataProvider
import com.example.affirmation.feature_assertion.domain.model.Affirmation
import com.example.affirmation.feature_assertion.presentation.component.AffirmationListCapsule
import com.example.affirmation.feature_assertion.presentation.list.AffirmationListCard
import com.example.affirmation.nav.SetupNavGraph
import com.example.affirmation.ui.theme.SaversTheme

class SecondActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            SetupNavGraph(navController)
            ListScreen()
        }
    }
}

@Composable
fun ListScreen(){
    SaversTheme {
                AffirmationListCapsule(DataProvider().loadAffirmations(), modifier = Modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun AffirmationListPreview() {
    SaversTheme {
        AffirmationListCard(
            affirmation = Affirmation(stringAffirmation = "Je me sens triste, et ça me fait mal")
        )
    }
}
