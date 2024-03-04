package com.parita.mentalhealthapp.screens.forgotpassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.parita.mentalhealthapp.ui.theme.Brown60
import com.parita.mentalhealthapp.ui.theme.Purple200
import com.parita.mentalhealthapp.ui.theme.Purple500
import com.parita.mentalhealthapp.ui.theme.Purple700
import com.parita.mentalhealthapp.ui.theme.Teal200

class PieChartFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                /*Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White)
                ) {
*/                    Column (modifier=Modifier.fillMaxSize().background(color= Color.Transparent), verticalArrangement = Arrangement.Center){
                        PieChart(
                            data = mapOf(
                                Pair("Sample-1", 150), Pair("Sample-2", 120),
                                Pair("Sample-3", 110), Pair("Sample-4", 170),
                                Pair("Sample-5", 120)
                            )
                        )
                    }

                }
            }
        }
 //   }
}

@Composable
fun PieChart(data: Map<String, Int>, radiusOuter: Dp = 90.dp, chartBarWidth: Dp = 20.dp, animDuration: Int = 1000) {
    val totalSum = data.values.sum()
    val floatValue = mutableListOf<Float>()
    data.values.forEachIndexed { index: Int, values: Int ->
        floatValue.add(index, 360 * values.toFloat() / totalSum.toFloat())
    }
    val colors = listOf(Purple200, Purple500, Teal200, Purple700, Color.Blue)
    var lastValue=0f
    var animationPlayed by remember { mutableStateOf(false) }
    val animateSize by animateFloatAsState(
        targetValue = if (animationPlayed) radiusOuter.value * 2f else 0f,
        animationSpec = tween(durationMillis = animDuration, delayMillis = 0, easing = LinearOutSlowInEasing), label = ""
    )
    val animateRotation by animateFloatAsState(
        targetValue = if (animationPlayed) 90f * 11f else 0f,
        animationSpec = tween(durationMillis = animDuration, delayMillis = 0, easing = LinearOutSlowInEasing), label = ""
    )
    LaunchedEffect(key1 = true) { animationPlayed = true }
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier.size(animateSize.dp), contentAlignment = Alignment.Center){
            Canvas(modifier = Modifier
                .size(radiusOuter * 2f)
                .rotate(animateRotation)){
                floatValue.forEachIndexed{index, value ->
                    drawArc(color = colors[index], lastValue, value, useCenter = false, style = Stroke(chartBarWidth.toPx(), cap = StrokeCap.Butt))
                    lastValue += lastValue
                }
            }
        }
    }
}

@Composable
fun DetailsPieChart(data: Map<String,Int>, colors: List<Color>){
    Column(modifier = Modifier
        .padding(top = 60.dp)
        .fillMaxWidth()) {
        data.values.forEachIndexed{ index, value ->
           DetailsPieChartItem(data = Pair(data.keys.elementAt(index),value), color= colors[index])
        }
    }
}

@Composable
fun DetailsPieChartItem(data: Pair<String,Int>,height: Dp=45.dp, color: Color){
    Surface(modifier = Modifier.padding(vertical = 10.dp, horizontal = 30.dp), color= Color.Transparent) {
        Row (modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
            Box(modifier = Modifier
                .background(color = color, shape = RoundedCornerShape(10.dp))
                .size(height))
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = data.first, modifier = Modifier.padding(start=15.dp), fontSize = 22.sp,color= Color.Black, fontWeight = FontWeight.Medium)
                Text(text = data.first, modifier = Modifier.padding(start=15.dp), fontSize = 22.sp,color= Color.Gray, fontWeight = FontWeight.Medium)
            }
        }
    }
}