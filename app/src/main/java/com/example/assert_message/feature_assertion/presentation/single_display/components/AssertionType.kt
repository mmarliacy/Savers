package com.example.assert_message.feature_assertion.presentation.single_display.components

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assert_message.SecondActivity
import com.example.assert_message.feature_assertion.domain.model.Assertion
import com.example.assert_message.ui.theme.protestRevolution


@Composable
fun AssertionBackground(modifier: Modifier = Modifier, context: Context, messageList: List<Assertion>){

    val color by remember {
        mutableStateOf(Color.White)
    }

    var index by remember {
        mutableIntStateOf(0)
    }

    var firstMessage by remember {
        mutableStateOf("Je suis magnifique")
    }
    val intent = Intent(context, SecondActivity::class.java)

    Column {
        Box( modifier = modifier
            .background(color)
            .weight(1f)
            .padding(20.dp)
            .clickable {
                firstMessage = messageList[index].message
                index++
                if (index == messageList.size) {
                    index = 0
                }
            },
            contentAlignment = Alignment.Center
        )
        {

            Text(
                text = firstMessage,
                fontSize = 35.sp,
                fontFamily = protestRevolution,
                color = Color.Black,
                textAlign = TextAlign.Center,
                letterSpacing = 2.sp,
                lineHeight = 60.sp
            )
        }
        GoToListButton(modifier = modifier.weight(0.15f), intent, context)
    }

}

@Composable
fun GoToListButton(modifier: Modifier, intent: Intent, context: Context){

    val buttonColor = remember {
        mutableStateOf(Color.Black)
    }
    Surface (
        modifier
            .fillMaxWidth()
            .padding(10.dp)) {
        Button(
            onClick = {
                buttonColor.value = Color.Blue
                context.startActivity(intent.setFlags((Intent.FLAG_ACTIVITY_NEW_TASK)))},
            modifier.background(buttonColor.value),
            colors = ButtonDefaults.buttonColors (
                Color.Transparent
            )
        ) {
                Text(
                    text = "Mes affirmations",
                    fontStyle = FontStyle.Normal,
                    fontSize = 20.sp,
                    color = Color.White
                )
        }
    }
}

