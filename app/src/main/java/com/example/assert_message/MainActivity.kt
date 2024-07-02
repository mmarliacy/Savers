package com.example.assert_message

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.assert_message.feature_assertion.presentation.single_display.components.AssertionBackground
import com.example.assert_message.feature_assertion.domain.model.Assertion
import com.example.assert_message.feature_assertion.domain.model.Assertion.Companion.messageList
import com.example.assert_message.ui.theme.AssertionTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val assertion = Assertion("My first assertion")

        setContent {
            val colorList by remember {
                mutableStateOf(
                    listOf(
                        Color.Blue,
                        Color.Gray,
                        Color.Green,
                        Color.Yellow,
                        Color.Cyan
                    )
                )
            }

            AssertionTheme {
                Surface {
                    AssertionBackground(
                        modifier = Modifier,
                        applicationContext,
                        messageList
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AssertionTheme {
        Greeting("Android")
    }
}