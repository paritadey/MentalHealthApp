package com.parita.mentalhealthapp.screens.forgotpassword

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.parita.mentalhealthapp.screens.setupscreen.MoodSetup
import com.parita.mentalhealthapp.ui.theme.Brown100
import com.parita.mentalhealthapp.ui.theme.Brown60
import com.parita.mentalhealthapp.ui.theme.step1Green
import com.parita.mentalhealthapp.ui.theme.step2Brown
import com.parita.mentalhealthapp.ui.theme.step3Yellow
import com.parita.mentalhealthapp.ui.theme.step4Blue
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
                        modifier = Modifier.background(color = Brown60),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        SpinWheel(
                            state = state,
                            onClick = { scope.launch { state.animate { pieIndex -> } } }
                        ) { pieIndex ->
                            androidx.compose.material.Text(text = textList[pieIndex])
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun CircularList(
    items: ArrayList<MoodSetup>,
    modifier: Modifier = Modifier,
    isEndless: Boolean = false,
    context: Context
) {
    val listState = rememberLazyListState(
        if (isEndless) Int.MAX_VALUE / 2 else 0
    )
    LazyRow(
        state = listState,
        modifier = modifier
    ) {
        items(
            count = if (isEndless) Int.MAX_VALUE else items.size,
            itemContent = {
                val index = it % items.size
                val lastIndex = items.size - 1
                Card(
                    shape = when (index) {
                        0 -> RoundedCornerShape(
                            topStart = 15.dp,
                            bottomEnd = 35.dp,
                            topEnd = 35.dp,
                            bottomStart = 15.dp
                        )

                        lastIndex -> RoundedCornerShape(
                            topStart = 35.dp,
                            bottomEnd = 15.dp,
                            topEnd = 15.dp,
                            bottomStart = 35.dp
                        )

                        else -> RoundedCornerShape(35.dp)
                    },
                    colors = CardDefaults.cardColors(
                        containerColor = items[index].moodColor,
                    ),
                    modifier = Modifier.size(width = 160.dp, height = 105.dp)//.padding(4.dp)
                ) {
                    Button(
                        onClick = {
                            Toast.makeText(
                                context,
                                "${items[index].moodName.toString()} is clicked",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        colors = ButtonDefaults.outlinedButtonColors(containerColor = items[index].moodColor),
                        modifier = Modifier.size(width = 160.dp, height = 105.dp)
                    ) {
                        Text(
                            text = items[index].moodName, color = Color.White,
                            style = MaterialTheme.typography.bodySmall.copy(color = Color.White),
                            modifier = Modifier.padding(
                                start = 16.dp,
                                end = 16.dp,
                                bottom = 30.dp,
                                top = 34.dp
                            ),
                            textAlign = TextAlign.Center,
                        )
                    }
                }// item composable
            }
        )
    }
}
