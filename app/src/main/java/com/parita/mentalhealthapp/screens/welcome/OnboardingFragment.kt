package com.parita.mentalhealthapp.screens.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.parita.mentalhealthapp.R
import com.parita.mentalhealthapp.screens.welcome.model.onboardPages
import com.parita.mentalhealthapp.ui.theme.Brown100
import com.parita.mentalhealthapp.ui.theme.Brown61
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    OnboardingUI(findNavController(),OnSkipClicked = { findNavController().navigate(R.id.viewOnboardingToLogin) })
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingUI(navController: NavController,OnSkipClicked: () -> Unit) {
    val pagerState = rememberPagerState(pageCount = 4)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Brown61),
    ) {
        Text(text = "Skip ",
            style = MaterialTheme.typography.bodyLarge.copy(color = Color.White),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().height(50.dp)
                .padding(start=270.dp, top=24.dp)
                .clickable { OnSkipClicked() })

        HorizontalPager(
            state = pagerState, modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { page ->
            OnboardingScreen(page = onboardPages[page])
        }

        HorizontalPagerIndicator(
            pagerState = pagerState, modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
            activeColor = Color.White
        )

        AnimatedVisibility(visible = pagerState.currentPage == 3) {
            OutlinedButton(
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .fillMaxWidth().height(60.dp)
                    .padding(start = 24.dp, top=14.dp, end=24.dp, bottom=8.dp),
                onClick = {navController.navigate(R.id.viewOnboardingToLogin)},
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = colorResource(
                        id = R.color.BROWN_100
                    ), colorResource(id = R.color.BROWN_100)
                )
            ) {
                Text(text = "Let's Start",
                    style = MaterialTheme.typography.bodySmall.copy(color = Color.White),
                    textAlign = TextAlign.Center)
            }
        }
    }
}
