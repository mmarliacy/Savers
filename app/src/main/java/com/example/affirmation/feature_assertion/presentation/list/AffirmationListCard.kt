package com.example.affirmation.feature_assertion.presentation.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.affirmation.feature_assertion.domain.model.Affirmation

@Composable
fun AffirmationListCard(affirmation: Affirmation) {

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(4.dp),
        content = {
            Column {
                Text(
                    text = affirmation.stringAffirmation,
                    Modifier.padding(16.dp),
                    fontSize = 25.sp,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        })
}