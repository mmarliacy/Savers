package com.example.affirmation.feature_assertion.presentation.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.affirmation.di.DataProvider

    @Composable
    fun AffirmationList(){
        Scaffold(
            content =
            {
                    padding ->
                AffirmationList(
                    DataProvider().loadAffirmations(),
                    modifier = Modifier.padding(padding)
                )
            }
        )
    }