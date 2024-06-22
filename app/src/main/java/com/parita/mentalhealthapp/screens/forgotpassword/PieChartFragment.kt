package com.parita.mentalhealthapp.screens.forgotpassword

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.parita.mentalhealthapp.R
import com.parita.mentalhealthapp.ui.theme.Brown61
import com.parita.mentalhealthapp.ui.theme.blueColor
import com.parita.mentalhealthapp.ui.theme.greenColor
import com.parita.mentalhealthapp.ui.theme.orangeColor
import com.parita.mentalhealthapp.ui.theme.redColor
import com.parita.mentalhealthapp.ui.theme.yellowColor

class PieChartFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Surface(modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)) {
                    CreatePieChart(findNavController())
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 290.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Bottom) {
                        ComposableBadgeView(findNavController())
                    }
                    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {
                        CreateHeaderView()
                    }
                }
            }
        }
    }
}

@Composable
fun CreateHeaderView(){
    Column(modifier= Modifier.fillMaxWidth().height(56.dp).background(color = Color.Blue), horizontalAlignment = Alignment.CenterHorizontally,){
        Column(modifier = Modifier
            .width(500.dp).height(58.dp)
            .padding(start=10.dp, end = 10.dp, top=12.dp, bottom = 12.dp)
            .background(color=Color.White.copy(0.15f), shape = RoundedCornerShape(24.dp)), verticalArrangement = Arrangement.Center){
            Text(text = "Header View", fontWeight = FontWeight(400), fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif, modifier = Modifier.padding(start=16.dp).height(20.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposableBadgeView(navController: NavController){
    Box(
        modifier = Modifier.size(44.dp),
        contentAlignment = Alignment.Center // Align content to the center of the box
    ) {
        BadgedBox(badge ={
            Badge(containerColor = Color.Red, contentColor = Color.White, content = {
                Text(text = "9", fontWeight = FontWeight(400), fontSize = 11.sp,
                    fontFamily = FontFamily.SansSerif)
            }, modifier = Modifier.offset(x=(-6).dp, y=5.dp))
        } ) {   
            Icon(painter = painterResource(id = com.parita.mentalhealthapp.R.drawable.instagram),
                modifier = Modifier.size(24.dp).clickable {
                     navController.navigate(R.id.action_pieChartFragment_to_glassmorphicFragment)
                }, contentDescription ="Instagram")
        }
    }
}

data class ChartValue(
    var pieDataName: String?,
    var value: Float?
)

val getPieChartData = listOf(
    ChartValue("Assets", 34.68F),
    ChartValue("Loan", 16.60F),
    ChartValue("Debt", 16.15F),
    ChartValue("Offset", 15.62F),
    ChartValue("Motion", 16.95F)
)

@Composable
fun CreatePieChart(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .padding(18.dp)
                    .size(320.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Crossfade(targetState = getPieChartData, label = "") { ChartValue ->
                    AndroidView(factory = { context ->
                        PieChart(context).apply {
                            layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.MATCH_PARENT,
                            )
                            this.description.isEnabled = false
                            this.isDrawHoleEnabled = false
                            this.legend.isEnabled = true
                            this.legend.textSize = 14F
                            this.legend.horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER

                            this.setEntryLabelColor(resources.getColor(R.color.BROWN_61))
                        }
                    },
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(5.dp), update = {
                            updatePieChartWithData(it, ChartValue)
                        })
                }
            }
            Column(modifier = Modifier
                .padding(18.dp)
                .size(300.dp),
                horizontalAlignment = Alignment.End,){
                androidx.compose.material3.Button(
                    onClick = { navController.navigate(R.id.action_pieChartFragment_to_recyclerGridFragment) },
                    shape = RoundedCornerShape(60.dp),
                    colors = ButtonDefaults.outlinedButtonColors(containerColor = Brown61),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(76.dp)
                        .padding(60.dp, 24.dp, 60.dp, 0.dp)
                ) {
                    Text(text = "Next ", color = Color.White)
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "sign in",
                        tint = Color.White
                    )
                }
            }
        }
    }
}

fun updatePieChartWithData(
    chart: PieChart,
    data: List<ChartValue>) {
    val entries = ArrayList<PieEntry>()
    for (i in data.indices) {
        val item = data[i]
        entries.add(PieEntry(item.value ?: 0.toFloat(), item.pieDataName ?: ""))
    }
    val ds = PieDataSet(entries, "")
    ds.colors = arrayListOf(
        greenColor.toArgb(),
        blueColor.toArgb(),
        redColor.toArgb(),
        yellowColor.toArgb(),
        orangeColor.toArgb()
    )
    ds.yValuePosition = PieDataSet.ValuePosition.INSIDE_SLICE
    ds.xValuePosition = PieDataSet.ValuePosition.INSIDE_SLICE
    ds.sliceSpace = 2f

    ds.valueTextColor =R.color.BROWN_61
    ds.valueTextSize = 18f
    ds.valueTypeface = Typeface.DEFAULT_BOLD
    val d = PieData(ds)
    chart.data = d
    chart.invalidate()
}

