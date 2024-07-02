package com.example.assert_message

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assert_message.feature_assertion.domain.model.Assertion
import com.example.assert_message.ui.theme.AssertionTheme
import kotlinx.coroutines.launch

class SecondActivity : ComponentActivity() {


    @SuppressLint("MutableCollectionMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AssertionTheme {
                val messageList by remember {
                    mutableStateOf(Assertion.messageList)
                }

                Surface(

                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 2.dp, vertical = 20.dp)
                        .background(Color.White)
                ) {
                    Column {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f)
                                .background(Color.White)
                        ) {
                            items(messageList) { message ->
                                MessageCard(message = message.message, modifier = Modifier)
                            }
                        }
                        AddNewAssertion(modifier = Modifier.weight(0.1f),messageList)
                    }
                }
            }
        }
    }

    @Composable
    fun MessageCard(message: String, modifier: Modifier) {
        Surface(
            modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 5.dp),
            border = BorderStroke(0.5.dp, Color.White),
            shape = MaterialTheme.shapes.large,
            shadowElevation = 2.dp,
            color = Color.White
        ) {
            Row(modifier = modifier.padding(vertical = 10.dp, horizontal = 10.dp)) {
                Text(
                    text = message,
                    fontSize = 18.sp,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Light,
                    color = Color.Black
                )
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun AddNewAssertion(modifier: Modifier, messageList: ArrayList<Assertion>) {
        val sheetState = rememberModalBottomSheetState()
        val scope = rememberCoroutineScope()
        var showBottomSheet by rememberSaveable { mutableStateOf(false) }
        var inputText by remember { mutableStateOf("") }

        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        )
        {
            Button(
                onClick = {
                    showBottomSheet = true
                },
                colors = ButtonDefaults.buttonColors(
                    Color.Black
                ),
                contentPadding = PaddingValues(20.dp),
                modifier = modifier.weight(1f)
            ) {
                Text(
                    text = "Ajouter une affirmation",
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp
                )
            }
        }

        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState
            ) {
                // Sheet content
                Surface {
                    Column(
                        modifier = modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top
                    ) {
                        Text(
                            text = "Nouvelle affirmation",
                            fontSize = 19.sp,
                            fontStyle = FontStyle.Italic,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.height(5.dp))

                        Box(
                            modifier = Modifier.padding(10.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            TextField(
                                value = inputText,
                                onValueChange = { inputText = it },
                                placeholder = { Text("Je suis...") },

                            )
                        }


                        Spacer(modifier = Modifier.height(2.dp))

                        Button(onClick = {
                            scope.launch {
                                sheetState.hide()
                                val newAssertion = Assertion(inputText)
                                messageList.add(newAssertion)
                            }.invokeOnCompletion {
                                if (!sheetState.isVisible) {
                                    showBottomSheet = false
                                }
                            }
                        }) {
                            Text("Ajouter")
                        }
                    }
                }


            }
        }
    }
}
