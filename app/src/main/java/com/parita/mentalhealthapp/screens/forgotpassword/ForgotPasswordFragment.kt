package com.parita.mentalhealthapp.screens.forgotpassword

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import coil.compose.AsyncImagePainter.State.Empty.painter
import com.parita.mentalhealthapp.R
import com.parita.mentalhealthapp.ui.theme.Brown60
import com.parita.mentalhealthapp.ui.theme.Brown61
import com.parita.spinewheel.SpinWheel
import com.parita.spinewheel.state.rememberSpinWheelState
import kotlinx.coroutines.launch

class ForgotPasswordFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Brown60)
                ) {
                    showWheel(requireContext())
                }
            }
        }
    }
}

@Composable
fun showWheel(context: Context) {
    val show = remember { mutableStateOf(false) }
    var emojiChoice = remember { mutableStateOf("") }
    val scrollState = rememberScrollState()
    val textList by remember {
        mutableStateOf(
            listOf(
                "Sad",
                "Happy",
                "Neutral",
                "Painful",
                "Upset",
                "Enjoy-ful",
                "Blissful",
                "Lucky"
            )
        )
    }
    val state = rememberSpinWheelState()
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .width(150.dp)
            .verticalScroll(scrollState)
            .background(color = Brown60),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly){
            IconButton(onClick = {  }, modifier = Modifier
                .width(30.dp)
                .padding(start = 10.dp)) {
                Icon(painterResource(id = com.google.android.material.R.drawable.ic_arrow_back_black_24), tint = Color.White,
                    contentDescription = "Back Arrow")
            }
            Text(
                modifier = Modifier
                    .width(230.dp)
                    .padding(start = 40.dp, top = 0.dp, bottom = 0.dp, end = 20.dp),
                text = "Assessment",
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.White, fontWeight= FontWeight(1000)),
                textAlign = TextAlign.Center,
            )
            Button(onClick = {}, shape = RoundedCornerShape(60.dp),
                colors= ButtonDefaults.outlinedButtonColors(containerColor = Brown61)
                , modifier = Modifier.width(90.dp)) {
                Text(text = "1/7", color=Color.White)
            }
        }
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly){
            Text(
                text = "How would you rate your mood ? ",
                style = MaterialTheme.typography.bodyLarge.copy(color = Color.White, fontWeight= FontWeight(1000)),
                textAlign = TextAlign.Center,
            )
        }

        if (show.value) {
            when(emojiChoice.value.toInt()){
                0->{
                    Image(painter = painterResource(id = R.drawable.sad),
                        contentDescription = "image",
                        contentScale = ContentScale.None,
                        modifier = Modifier
                            .width(150.dp))
                }
                1->{Image(painter = painterResource(id = R.drawable.smiley),
                    contentDescription = "image",
                    contentScale = ContentScale.None,
                    modifier = Modifier
                        .width(150.dp))
                }
                2->{
                    Image(painter = painterResource(id = R.drawable.neutral),
                        contentDescription = "image",
                        contentScale = ContentScale.None,
                        modifier = Modifier
                            .width(150.dp))
                }
                3->{
                    Image(painter = painterResource(id = R.drawable.painful),
                        contentDescription = "image",
                        contentScale = ContentScale.None,
                        modifier = Modifier
                            .width(150.dp))
                }
                4-> {
                    Image(painter = painterResource(id = R.drawable.upset),
                        contentDescription = "image",
                        contentScale = ContentScale.None,
                        modifier = Modifier
                            .width(150.dp))
                }
                5->{
                    Image(painter = painterResource(id = R.drawable.enjoy),
                        contentDescription = "image",
                        contentScale = ContentScale.None,
                        modifier = Modifier
                            .width(150.dp))
                }
                6->{
                    Image(painter = painterResource(id = R.drawable.blissful),
                        contentDescription = "image",
                        contentScale = ContentScale.None,
                        modifier = Modifier
                            .width(150.dp))
                }
                7->{
                    Image(painter = painterResource(id = R.drawable.lucky),
                        contentDescription = "image",
                        contentScale = ContentScale.None,
                        modifier = Modifier
                            .width(150.dp))
                }
                else -> {Image(painter = painterResource(id = R.drawable.logomark),
                    contentDescription = "image",
                    contentScale = ContentScale.None,
                    modifier = Modifier
                        .width(150.dp)
                        .padding(top = 20.dp),
                )}
            }

        }
      //  Spacer(modifier = Modifier.padding(top = 250.dp))
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly) {
            Image(painter = painterResource(id = R.drawable.solid_chevron_double_down_sm),
                contentDescription = "image",
                contentScale = ContentScale.None,
                modifier = Modifier
                    .width(150.dp))
        }
        SpinWheel(
            state = state,
            onClick = {
                scope.launch {
                    state.animate { pieIndex ->
                        emojiChoice.value = pieIndex.toString()
                        Toast.makeText(context, "Mood of the day  : ${textList[pieIndex]}", Toast.LENGTH_SHORT).show()
                        show.value = true
                    }
                }
            }
        ) { pieIndex ->
            androidx.compose.material.Text(text = textList[pieIndex])
        }
    }
}
