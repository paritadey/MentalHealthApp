package com.parita.mentalhealthapp.screens.forgotpassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import kotlin.random.Random

class RecyclerGridFragment : Fragment() {
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
                        .background(color = Color.White)
                ) {
                    //ShowHorizontalGridView()
                  //  ShowVerticalGridView()
                    LazyHorizontalGridScreen()
                }
            }
        }
    }
}

data class ListItem(val size: Dp, val color: Color)
data class Item(val height: Dp, val color: Color)

@Composable
fun RandomColorBox(item: Item) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(item.height)
            .clip(RoundedCornerShape(10.dp))
            .background(item.color)
    )
}

@Composable
fun ShowHorizontalGridView() {
    val sizeColorList = (1..10).map {
        ListItem(
            size = Random.nextInt(100, 300).dp,
            color = Color(Random.nextLong(0xFFFFFFFF)).copy(alpha = 1f)
        )
    }

    LazyHorizontalStaggeredGrid(
        rows = StaggeredGridCells.Adaptive(250.dp),
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(10.dp),
        horizontalItemSpacing = 10.dp,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        itemsIndexed(sizeColorList) { index, item ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .width(item.size)
                    .background(item.color, shape = RoundedCornerShape(10.dp))
            ) {
                Text(
                    text = "$index",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

    }

}

@Composable
fun ShowVerticalGridView() {
    val items = (1..100).map {
        Item(
            height = Random.nextInt(100, 300).dp,
            color = Color(Random.nextLong(0xFFFFFFFF)).copy(alpha = 1f)
        )
    }

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalItemSpacing = 16.dp,
        contentPadding = PaddingValues(16.dp)
    ) {
        items(items) { item ->
            RandomColorBox(item = item)
        }
    }
}
@Composable
fun LazyHorizontalGridScreen() {
    LazyHorizontalGrid(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        rows = GridCells.Fixed(2)) {
        items(20) { index ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .width(100.dp)
                    .background(Color.Gray, shape = RoundedCornerShape(4.dp))
                    .border(width = 2.dp, color =Color.Black, shape = RoundedCornerShape(4.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "$index", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}
