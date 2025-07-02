package com.example.learn_together

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learn_together.ui.theme.Learn_togetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Learn_togetherTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    ArticleScreen(modifier = Modifier.padding(innerPadding))
//                    TaskScreen(modifier = Modifier.padding(innerPadding))
//                    ComposeQuad(modifier = Modifier.padding(innerPadding))
                    BusinessCard(modifier = Modifier.padding(innerPadding))
                }

            }
        }
    }
}

@Composable
fun ArticleScreen(modifier: Modifier = Modifier){
    val myImage = painterResource(R.drawable.bg_compose_background)
    Column {
        Image(
            painter = myImage,
            contentDescription = null
        )
        Text(
            stringResource(R.string.jetpack_compose_tutorial),
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            stringResource(R.string.second_para),
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            stringResource(R.string.third_para),
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun TaskScreen(modifier: Modifier = Modifier){

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.ic_task_completed),
            contentDescription = null,
        )
        Text(
            "All tasks completed",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Text(
            "Nice work",
            fontSize = 16.sp,
        )
    }
}

@Composable
fun ComposeQuad(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize()) {
        // First Row - Top half
        Row(modifier = Modifier.weight(1f)) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color(0xFFEADDFF)),
                contentAlignment = Alignment.Center

            ){
                Column(modifier = Modifier.padding(16.dp),horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Text composable", fontWeight = FontWeight.Bold)
                    Text("Displays text and follows the recommended Material Design guidelines.\n",
                        textAlign = TextAlign.Justify)
                }
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color(0xFFD0BCFF)),
                contentAlignment = Alignment.Center
            ){
                Column(modifier = Modifier.padding(16.dp),horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Image composable\n", fontWeight = FontWeight.Bold)
                    Text("Creates a composable that lays out and draws a given Painter class object.",
                        textAlign = TextAlign.Justify)
                }
            }
        }

        // Second Row - Bottom half
        Row(modifier = Modifier.weight(1f)) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color(0xFFB69DF8)),
                contentAlignment = Alignment.Center

            ){
                Column(modifier = Modifier.padding(16.dp),horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Row composable", fontWeight = FontWeight.Bold)
                    Text("A layout composable that places its children in a horizontal sequence.\n",
                        textAlign = TextAlign.Justify)
                }
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color(0xFFF6EDFF)),
                contentAlignment = Alignment.Center
            ){
                Column(modifier = Modifier.padding(16.dp),horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Column composable\n", fontWeight = FontWeight.Bold)
                    Text("A layout composable that places its children in a vertical sequence.\n",
                        textAlign = TextAlign.Justify)
                }
            }
        }
    }
}
@Composable
fun UserDetails() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .padding(bottom = 10.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = "Android Logo",
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .background(Color(0xFF083041))
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.sameed_sharif),
            fontSize = 30.sp
        )
        Text(
            text = "Software Engineer",
            color = Color(0xFF106F3F),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun IconRender(
    text: String,
    icon: ImageVector
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 6.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            tint = Color(0xFF106F3F)
        )
        Spacer(modifier = Modifier.width(15.dp))
        Text(text)
    }
}
@Composable
fun BusinessCard(modifier: Modifier=Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD2E7D4)),
        contentAlignment = Alignment.Center // Centers UserDetails
    ) {
        // Centered UserDetails
        UserDetails()

        // ContactInformation aligned to the bottom
        ContactInformation(
            modifier = Modifier
                .align(Alignment.BottomCenter) // Align to bottom
                .padding(bottom = 50.dp) // Add bottom padding
        )
    }
}

@Composable
fun ContactInformation(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier, // Apply alignment and padding from parent
    ) {
        IconRender(
            text = "+1 234-567-8901",
            icon = Icons.Filled.Call
        )
        IconRender(
            text = "@AndroidDev",
            icon = Icons.Filled.Share
        )
        IconRender(
            text = "sameedsharif54@gmail.com",
            icon = Icons.Filled.Email
        )
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Learn_togetherTheme {
        BusinessCard()
    }
}