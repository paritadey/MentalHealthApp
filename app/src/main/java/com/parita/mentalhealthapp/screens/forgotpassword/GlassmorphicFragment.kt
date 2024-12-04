package com.parita.mentalhealthapp.screens.forgotpassword

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.parita.mentalhealthapp.MentalHealthApp
import com.parita.mentalhealthapp.R
import dev.shreyaspatil.capturable.Capturable
import dev.shreyaspatil.capturable.controller.rememberCaptureController
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

const val BLURRED_BG_KEY = "BLURRED_BG_KEY"
const val BLUR_RADIUS = 50

class GlassmorphicFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
//            setContent {
//                Surface(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(color = Color.White)
//                ) {
//                    Sample()
//                }
//            }
        }

    }
}
//@Composable
//fun Sample() {
//    val screenWidthDp = LocalConfiguration.current.screenWidthDp
//    val cardWidthDp = screenWidthDp
//    var capturedBitmap by remember { mutableStateOf<Bitmap?>(MentalHealthApp.getInstance().memoryCache[BLURRED_BG_KEY]) }
//
//    val scrollState = rememberScrollState()
//    val items = arrayListOf<Int>()
//    for (i in 0 until 1) {
//        items.add(i)
//    }
//
//    Box(modifier = Modifier.fillMaxSize()) {
//        val captureController = rememberCaptureController()
//        Capturable(
//            controller = captureController,
//            onCaptured = { bitmap, _ ->
//                // This is captured bitmap of a content inside Capturable Composable.
//                bitmap?.let {
//                    fastblur(it.asAndroidBitmap(), 1f, BLUR_RADIUS)?.let { fastBlurred ->
//                        // Bitmap is captured successfully. Do something with it!
//                        MentalHealthApp.getInstance().memoryCache.put(BLURRED_BG_KEY, fastBlurred)
//                        capturedBitmap = fastBlurred
//                    }
//                }
//            }
//
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.bg_autumn),
//                contentDescription = "",
//                modifier = Modifier.fillMaxSize(),
//                contentScale = ContentScale.Crop
//            )
//        }
//        LaunchedEffect(key1 = true, block = {
//            withContext(Dispatchers.Main) {
//                if (capturedBitmap == null) captureController.capture()
//            }
//        })
//
//        val childMeasures = remember { items.map { Place() }.toImmutableList() }
//
//        capturedBitmap?.let { capturedImage ->
//            GlassmorphicColumn(
//                modifier = Modifier.padding(start = 0.dp),
//                scrollState = scrollState,
//                childMeasures = childMeasures,
//                targetBitmap = capturedImage.asImageBitmap(),
//                dividerSpace = 10,
//                blurRadius = BLUR_RADIUS,
//                drawOnTop = { path ->
//                    val strokeColor = Color(0x80ffffff)
//                    val transparent = Color.Transparent
//                    drawPath(
//                        path = path,
//                        color = strokeColor,
//                        style = Stroke(1f),
//                    )
//
//                },
//                content = {
//                    items.forEachIndexed { index, it ->
//                        Box(
//                            modifier = Modifier
//                                //                            .background(Color(0x80FF0000))
//                                .onGloballyPositioned {
//                                    childMeasures[index].apply {
//                                        sizeX = it.size.width
//                                        sizeY = it.size.height
//                                        offsetX = it.positionInParent().x
//                                        offsetY = it.positionInParent().y
//                                    }
//                                }
//                                .width(cardWidthDp.dp)
//                                .padding(15.dp)
//                        ) {
//                            androidx.compose.material.Text(
//                                "Item $it",
//                                color = Color.Black
//                            )
//                        }
//                    }
//                },
//            )
//
//        }
//    }
//}
//@Composable
//fun ShowCard(){
//
//}