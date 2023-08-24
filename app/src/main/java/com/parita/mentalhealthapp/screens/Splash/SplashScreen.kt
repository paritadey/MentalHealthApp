package com.parita.mentalhealthapp.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.parita.mentalhealthapp.R
import com.parita.mentalhealthapp.navigation.Screens
import com.parita.mentalhealthapp.screens.Splash.AnimatedCircularProgressIndicator
import com.parita.mentalhealthapp.ui.theme.Brown100
import com.parita.mentalhealthapp.ui.theme.Brown50
import com.parita.mentalhealthapp.ui.theme.Brown60
import com.parita.mentalhealthapp.ui.theme.Pink80
import com.parita.mentalhealthapp.ui.theme.Purple80
import com.parita.mentalhealthapp.ui.theme.PurpleGrey40

@Composable
fun SplashScreen(navController: NavController) {
    Surface(modifier = Modifier.fillMaxWidth().background(color= Brown60)) {
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
}
