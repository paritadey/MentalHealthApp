package com.parita.mentalhealthapp.screens.Login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.TextFieldDecorationBox
import androidx.compose.material3.TextFieldDefaults.indicatorLine
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.parita.mentalhealthapp.R
import com.parita.mentalhealthapp.ui.theme.Brown100
import com.parita.mentalhealthapp.ui.theme.Brown61
import com.parita.mentalhealthapp.ui.theme.Green80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    var phoneState by remember { mutableStateOf(TextFieldValue("")) }
    val enabled = true
    val singleLine = true
    var passwordState by remember { mutableStateOf(TextFieldValue("")) }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .width(150.dp)
            .height(200.dp).verticalScroll(scrollState)
            .background(color = Brown100),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.ellipse_login_top),
            contentDescription = "image",
            contentScale = ContentScale.None
        )
    }
    Column(
        modifier = Modifier.padding(start = 0.dp, top = 100.dp, end = 0.dp, bottom = 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.logomark),
            contentDescription = "image",
            contentScale = ContentScale.None
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 0.dp, top = 50.dp, bottom = 0.dp, end = 0.dp),
            text = "Sign In To freud.ai",
            style = MaterialTheme.typography.bodyLarge.copy(color = Color.White),
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 14.dp, top = 48.dp, bottom = 0.dp, end = 0.dp),
            text = "Mobile Number",
            style = MaterialTheme.typography.bodySmall.copy(color = Color.White),
            textAlign = TextAlign.Start
        )
        TextField(
            value = phoneState,
            onValueChange = { newText ->
                phoneState = newText
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Call, tint = Color.White,
                    contentDescription = "Phone Icon"
                )
            },
            placeholder = { Text(text = "Enter your mobile number...", color=Color.White) },
            colors = TextFieldDefaults.textFieldColors(textColor = White,
                cursorColor = White,
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            enabled = enabled,
            singleLine = singleLine,
            textStyle = TextStyle(
                color = Color.White,
                fontFamily = MaterialTheme.typography.bodyMedium.fontFamily
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 14.dp, top = 10.dp, bottom = 0.dp, end = 14.dp)
                .border(2.dp, Green80),
            shape = RoundedCornerShape(8.dp),
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 14.dp, top = 12.dp, bottom = 0.dp, end = 0.dp),
            text = "Password",
            style = MaterialTheme.typography.bodySmall.copy(color = Color.White),
            textAlign = TextAlign.Start
        )
        TextField(
            value = passwordState,
            onValueChange = { newText ->
                passwordState = newText
            },
            leadingIcon = {
                Icon(
                    painterResource(id = R.drawable.password), tint = Color.White,
                    contentDescription = "Password icon"
                )
            },
            trailingIcon = {
                Icon(
                    painterResource(id = R.drawable.password_eye), tint = Color.White,
                    contentDescription = "Show Password"
                )
            },
            placeholder = { Text(text = "Enter your password...", color=Color.White) },
            colors = TextFieldDefaults.textFieldColors(textColor = White,
                cursorColor = White,
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            enabled = enabled,
            singleLine = singleLine,
            textStyle = TextStyle(
                color = Color.White,
                fontFamily = MaterialTheme.typography.bodyMedium.fontFamily
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 14.dp, top = 10.dp, bottom = 0.dp, end = 14.dp)
                .border(2.dp, Green80),
            shape = RoundedCornerShape(8.dp),
        )
        Button(onClick = {navController.navigate(R.id.viewHome)}, shape = RoundedCornerShape(20.dp),
            colors= ButtonDefaults.outlinedButtonColors(containerColor = Brown61)
        , modifier = Modifier
                .fillMaxWidth()
                .height(76.dp)
                .padding(14.dp, 24.dp, 14.dp, 0.dp)) {
            Text(text = "Sign in ", color=Color.White)
            Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "sign in", tint= White)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp, 68.dp, 14.dp, 0.dp), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = {}, shape = RoundedCornerShape(40.dp),
                colors= ButtonDefaults.outlinedButtonColors(containerColor = Brown61)
                , modifier = Modifier
                    .width(64.dp)
                    .height(64.dp)) {
                Icon(
                    painterResource(id = R.drawable.facebook), tint = Color.White,
                    contentDescription = "facebook"
                )
            }
            Button(onClick = {}, shape = RoundedCornerShape(40.dp),
                colors= ButtonDefaults.outlinedButtonColors(containerColor = Brown61)
                , modifier = Modifier
                    .width(64.dp)
                    .height(64.dp)) {
                Icon(
                    painterResource(id = R.drawable.google), tint = Color.White,
                    contentDescription = "google"
                )
            }
            Button(onClick = {}, shape = RoundedCornerShape(40.dp),
                colors= ButtonDefaults.outlinedButtonColors(containerColor = Brown61)
                , modifier = Modifier
                    .width(64.dp)
                    .height(64.dp)) {
                Icon(
                    painterResource(id = R.drawable.instagram), tint = Color.White,
                    contentDescription = "instagram"
                )
            }
        }
        Button(onClick = {navController.navigate(R.id.viewSignUp)},
            colors= ButtonDefaults.outlinedButtonColors(containerColor = Brown100)
            , modifier = Modifier.fillMaxWidth().padding(14.dp, 12.dp, 14.dp, 0.dp)) {
            Text(
                text = "Don't have an account?",
                style = MaterialTheme.typography.bodySmall.copy(color = Color.White),
                textAlign = TextAlign.Center
            )
            Text(text = "Sign Up ",  style = MaterialTheme.typography.bodyMedium.copy(color = Brown61),
                textAlign = TextAlign.Center)
        }
        Button(onClick = {},
            colors= ButtonDefaults.outlinedButtonColors(containerColor = Brown100)
            , modifier = Modifier.fillMaxWidth().padding(14.dp, 0.dp, 14.dp, 0.dp)) {
            Text(text = "Forgot Password ",  style = MaterialTheme.typography.bodyMedium.copy(color = Brown61),
                textAlign = TextAlign.Center)
        }
    }

}