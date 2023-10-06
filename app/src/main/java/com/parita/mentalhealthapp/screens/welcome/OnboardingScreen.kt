package com.parita.mentalhealthapp.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.parita.mentalhealthapp.screens.welcome.model.OnboardingPage
import com.parita.mentalhealthapp.ui.theme.Brown100
import com.parita.mentalhealthapp.ui.theme.Brown61

@Composable
fun OnboardingScreen (page: OnboardingPage){
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)
            .background(color = Brown61),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Image(painter = painterResource(id = page.image) , contentDescription = "Step Number")
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier.width(70.dp).height(18.dp)
                .clip(CircleShape)
                .background(color = page.background),
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text ="Step "+ page.stepNumber.toString(),
                style = MaterialTheme.typography.bodySmall.copy(color = Color.White),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = page.title,
            style = MaterialTheme.typography.bodyLarge.copy(color = Color.White),
            textAlign = TextAlign.Center
        )
        if(page.stepNumber!=4) {
            Button(
                onClick = {},
                shape = RoundedCornerShape(40.dp),
                colors = ButtonDefaults.outlinedButtonColors(containerColor = page.background),
                modifier = Modifier
                    .width(64.dp)
                    .height(64.dp).padding(start=0.dp, top=24.dp, end=0.dp, bottom = 0.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "sign in",
                    tint = Color.White
                )
            }
        }
    }
}