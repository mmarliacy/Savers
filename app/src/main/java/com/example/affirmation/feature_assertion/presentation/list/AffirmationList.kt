package com.example.affirmation.feature_assertion.presentation.list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.affirmation.feature_assertion.domain.model.Affirmation

@Composable
fun AffirmationList(affirmationList : List<Affirmation>, modifier: Modifier) {
    LazyColumn (
        modifier = modifier
    ){
        items(affirmationList){ affirmation ->
            AffirmationListCard(affirmation = affirmation)
        }
    }
}