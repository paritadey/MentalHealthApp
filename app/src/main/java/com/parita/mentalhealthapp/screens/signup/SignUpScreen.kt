package com.parita.mentalhealthapp.screens.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.parita.mentalhealthapp.R
import com.parita.mentalhealthapp.ui.theme.Brown100
import com.parita.mentalhealthapp.ui.theme.Brown61
import com.parita.mentalhealthapp.ui.theme.Green80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    var phoneState by remember { mutableStateOf(TextFieldValue("")) }
    val enabled = true
    val singleLine = true
    var passwordState by remember { mutableStateOf(TextFieldValue("")) }
    var checkedState = remember { mutableStateOf(false) }

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
            text = "Sign Up To freud.ai",
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
            placeholder = { Text(text = "Enter your mobile number...", color = Color.White) },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.White,
                cursorColor = Color.White,
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
            placeholder = { Text(text = "Enter your password...", color = Color.White) },
            colors = TextFieldDefaults.textFieldColors(
                textColor = White,
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
        /*Button(onClick = { *//*TODO*//* },shape= RoundedCornerShape(20.dp),
            colors= ButtonDefaults.outlinedButtonColors(containerColor = Brown30)
            , modifier = Modifier.fillMaxWidth().height(46.dp)
                .padding(14.dp, 12.dp, 14.dp, 0.dp))  {
            Text(text = "Invalid phone number ", color=White)

        }*/
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp, 10.dp, 12.dp, 0.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it },
                colors = CheckboxDefaults.colors(checkmarkColor = Green80, uncheckedColor= Green80, checkedColor= White)
            )
            Text(
                text = "Accept all terms and conditions",
                modifier = Modifier.padding(1.dp),
                style = MaterialTheme.typography.bodySmall.copy(color = Color.White),
                textAlign = TextAlign.Start
            )
        }
        Button(onClick = {navController.navigate(R.id.viewHome)}, shape = RoundedCornerShape(20.dp),
            colors= ButtonDefaults.outlinedButtonColors(containerColor = Brown61)
            , modifier = Modifier
                .fillMaxWidth()
                .height(76.dp)
                .padding(14.dp, 24.dp, 14.dp, 0.dp)) {
            Text(text = "Sign Up ", color=Color.White)
            Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "sign up", tint= White)
        }
        Button(onClick = {},
            colors= ButtonDefaults.outlinedButtonColors(containerColor = Brown100)
            , modifier = Modifier.fillMaxWidth().padding(14.dp, 12.dp, 14.dp, 0.dp)) {
            Text(
                text = "Already have an account?",
                style = MaterialTheme.typography.bodySmall.copy(color = Color.White),
                textAlign = TextAlign.Center
            )
            Text(text = "Sign In ",  style = MaterialTheme.typography.bodyMedium.copy(color = Brown61),
                textAlign = TextAlign.Center)
        }
    }
}