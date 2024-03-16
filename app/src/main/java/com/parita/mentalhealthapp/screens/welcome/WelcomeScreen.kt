package com.parita.mentalhealthapp.screens.welcome

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.parita.mentalhealthapp.ui.theme.Brown61
import com.parita.mentalhealthapp.ui.theme.onboarding

@Composable
fun WelcomeScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current
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
            Button(onClick = {navController.navigate(R.id.viewOnBoarding)}, shape = RoundedCornerShape(60.dp),
                colors= ButtonDefaults.outlinedButtonColors(containerColor = Brown61)
                , modifier = Modifier
                    .fillMaxWidth()
                    .height(76.dp)
                    .padding(60.dp, 24.dp, 60.dp, 0.dp)) {
                Text(text = "Get started ", color=Color.White)
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "sign in", tint= Color.White)
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
                ClickableText(text = AnnotatedString("Sign In"),style = MaterialTheme.typography.bodyMedium.copy(color = Brown61),
                    onClick = {Toast.makeText(context, "Sign in clicked", Toast.LENGTH_SHORT).show()})
            }
        }
    }
}
