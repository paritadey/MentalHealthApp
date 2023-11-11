package com.parita.mentalhealthapp.screens.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.parita.mentalhealthapp.ui.theme.Brown100
import com.parita.mentalhealthapp.ui.theme.Brown60
import com.parita.mentalhealthapp.ui.theme.Brown61

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Brown100),
    ) {
        Text(
            text = "Assessment", textAlign = TextAlign.Start,
            style = MaterialTheme.typography.bodyMedium.copy(color = Color.White),
        )
    }
}