package com.parita.mentalhealthapp.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.parita.mentalhealthapp.R
import com.parita.mentalhealthapp.screens.Login.LoginFragmentDirections.Companion.viewSignUp
import com.parita.mentalhealthapp.ui.theme.Brown61
import com.parita.mentalhealthapp.ui.theme.onboarding
import kotlinx.coroutines.delay

@Composable
fun WelcomeScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    var enabled by remember { mutableStateOf(true)}
    var getStarted by remember {
        mutableStateOf(false)
    }
    var enableGetStarted by remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = onboarding)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .background(color = onboarding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ){
            Image(painter = painterResource(id = R.drawable.logomark), contentDescription = "image", contentScale = ContentScale.None)
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 16.dp, bottom = 0.dp, end = 20.dp),
                text = "Welcome to the ultimate freud UI Kit!",
                style = MaterialTheme.typography.titleMedium.copy(color = Color.White),
                textAlign = TextAlign.Center,
            )
            Text(
                text = "Your mindful mental health AI companion for everyone, anywhere 🍃",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 16.dp, bottom = 0.dp, end = 20.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleSmall.copy(color = Color.White),
            )
            Image(painter = painterResource(id = R.drawable.welcome_step_one),
                modifier = Modifier.padding(0.dp, 32.dp, 0.dp, 0.dp),
                contentDescription = "image", contentScale = ContentScale.None)
            Button(onClick = {
                getStarted = true
                enableGetStarted = true
                             }, shape = RoundedCornerShape(60.dp),
                colors= ButtonDefaults.outlinedButtonColors(containerColor = Brown61)
                , modifier = ChangeButtonSizeOnClicked(enableGetStarted)) {
                if(getStarted) {
                    CircularProgressIndicator(
                        color = Color.White,
                        modifier = Modifier.wrapContentSize(align = Alignment.Center),
                        strokeWidth = 2.dp
                    )
                    LaunchedEffect(key1 = Unit) {
                        delay(4000)
                        if(enableGetStarted) navController.navigate(R.id.viewOnBoarding)
                    }
                }
                if(!getStarted) {
                    Text(text = "Get started ", color = Color.White)
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "sign in",
                        tint = Color.White
                    )
                }
            }
            Button(onClick = {navController.navigate(R.id.viewSignUp)},
                colors= ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent)
                , modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp, 12.dp, 14.dp, 0.dp)) {
                Text(
                    text = "Already have an account?",
                    style = MaterialTheme.typography.bodySmall.copy(color = Color.White),
                    textAlign = TextAlign.Center
                )
                ClickableText(
                    text = AnnotatedString("Sign In") ,
                    style = MaterialTheme.typography.bodyMedium.copy(color = Brown61),
                    onClick = {
                        if (enabled) {
                            enabled = false
                            navController.navigate(R.id.action_welcomeScreenFragment_to_shimmerFragment)
                        }
                    })
            }
        }
    }
}

@Composable
fun ChangeButtonSizeOnClicked(enable: Boolean): Modifier {
    return if (!enable) Modifier.fillMaxWidth().height(76.dp).padding(60.dp, 24.dp, 60.dp, 0.dp)
    else Modifier.width(80.dp).height(80.dp)//.padding(10.dp)
}
