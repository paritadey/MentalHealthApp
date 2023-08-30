package com.parita.mentalhealthapp.screens.Splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.parita.mentalhealthapp.R
import com.parita.mentalhealthapp.screens.Splash.AnimatedCircularProgressIndicator
import com.parita.mentalhealthapp.screens.Splash.SplashViewModel
import com.parita.mentalhealthapp.ui.theme.Brown40
import com.parita.mentalhealthapp.ui.theme.Brown50
import com.parita.mentalhealthapp.ui.theme.Brown60
import com.parita.mentalhealthapp.ui.theme.Green70
import kotlinx.coroutines.delay


@Composable
fun SplashScreen() {
    var show = remember { mutableStateOf(true) }
    var showScreen = remember { mutableStateOf(true) }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Brown60)
    ) {
        screenOne()
        LaunchedEffect(key1 = Unit) {
            delay(5000)
            show.value = false
        }
        if (!show.value) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                screenTwo()
                LaunchedEffect(key1 = Unit) {
                    delay(5000)
                    showScreen.value = false
                }
            }
            if (!showScreen.value) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    screenThree()
                }
            }
        }
    }
}

@Composable
fun screenThree() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Brown40)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Brown40),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth().padding(start=20.dp, top=0.dp, bottom=0.dp, end=20.dp),
                text = "“In the midst of winter, I found there was within me an invincible summer.”",
                style = MaterialTheme.typography.bodyLarge.copy(color = Color.White),
                textAlign = TextAlign.Center,
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Universal Facts",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(800),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center,
                    letterSpacing = 1.4.sp,
                )
            )
        }
    }
}

@Composable
fun screenTwo() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Green70),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                text = "Fetching Data...",
                style = MaterialTheme.typography.headlineMedium.copy(color = Color.White),
                textAlign = TextAlign.Center,
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 0.dp, end = 16.dp, bottom = 0.dp),
                text = "Shake your screen to interact!",
                style = MaterialTheme.typography.bodySmall.copy(color = Color.White),
                textAlign = TextAlign.Center,
            )
        }
        Column(
            modifier = Modifier
                .width(150.dp)
                .height(150.dp)
                .padding(start = 50.dp, top = 0.dp, end = 50.dp, bottom = 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.ellipse_green_top),
                contentDescription = "image",
                contentScale = ContentScale.None
            )
        }
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End
        ) {
            Image(
                painter = painterResource(id = R.drawable.ellipse_green_left),
                contentDescription = "image",
                contentScale = ContentScale.None
            )
        }
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = painterResource(id = R.drawable.ellipse_green_right),
                contentDescription = "image",
                contentScale = ContentScale.None
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .width(50.dp)
                .height(50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Image(
                painter = painterResource(id = R.drawable.ellipse_green_bottom),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )
        }
    }
}

@Composable
fun screenOne() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Brown60),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        AnimatedCircularProgressIndicator(
            currentValue = 90, maxValue = 100, progressBackgroundColor = Color.White,
            progressIndicatorColor = Brown50,
            completedColor = Color.White
        )
    }
    Column(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .padding(start = 50.dp, top = 0.dp, end = 50.dp, bottom = 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.bottom_circle),
            contentDescription = "image",
            contentScale = ContentScale.None
        )
    }
    Column(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .padding(start = 50.dp, top = 0.dp, end = 50.dp, bottom = 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Image(
            painter = painterResource(id = R.drawable.bottom_circle),
            contentDescription = "image description",
            contentScale = ContentScale.None
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End
    ) {
        Image(
            painter = painterResource(id = R.drawable.ellipse_end),
            contentDescription = "image",
            contentScale = ContentScale.None
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = painterResource(id = R.drawable.ellipse_start),
            contentDescription = "image",
            contentScale = ContentScale.None
        )
    }
}