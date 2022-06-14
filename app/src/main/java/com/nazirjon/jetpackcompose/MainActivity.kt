package com.nazirjon.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nazirjon.jetpackcompose.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeLearningTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                    ScrollStateCompose()
                    EventClick()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val innerPadding = PaddingValues(top = mTop30, start = mStart30)
    Box(
        contentAlignment = Alignment.CenterEnd,
        modifier = Modifier
            .size(400.dp, 250.dp)
            .background(Color.Blue)
    ) {
        Text(
            text = "Hello $name!",
            fontSize = 22.sp,
            color = mGreen,
            modifier = Modifier
                .size(width = 300.dp, height = 200.dp)
                .padding(mPadding30)
                .offset(x = 20.dp, y = 25.dp)
                .background(color = mBackground)
                .widthIn(min = 100.dp, max = mWidth)
                .heightIn(min = 50.dp, max = mHeight)
                .padding(innerPadding)
        )
    }
}

@Composable
fun ScrollStateCompose() {
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .size(200.dp, 250.dp)
            .background(Color.DarkGray)
    ) {
        Text(
            "What is Lorem Ipsum?\n" +
                    "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                    "\n" +
                    "...............",
            fontSize = 22.sp,
            modifier = Modifier
                .background(color = Color.Yellow)
                .verticalScroll(rememberScrollState())
                .horizontalScroll(rememberScrollState())
        )
    }
}

@Composable
fun EventClick() {
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .size(200.dp, 250.dp)
            .background(Color.Green)
    ) {
        val count = remember { mutableStateOf(0) }
        Text(
            "Clicks: ${count.value}",
            fontSize = 28.sp,
            modifier = Modifier
                .clickable(onClick = { count.value += 1 })
                .size(width = 200.dp, height = 60.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeLearningTheme {
        Greeting("Android")
        ScrollStateCompose()
        EventClick()
    }
}