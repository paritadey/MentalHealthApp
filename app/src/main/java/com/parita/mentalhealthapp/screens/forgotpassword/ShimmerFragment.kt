package com.parita.mentalhealthapp.screens.forgotpassword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.navigation.fragment.findNavController
import com.parita.mentalhealthapp.R
import com.parita.mentalhealthapp.ui.theme.AnimatedShimmerEffectTheme
import com.parita.mentalhealthapp.ui.theme.Brown60
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShimmerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                AnimatedShimmerEffectTheme {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = Brown60)
                    ) {
                        AnimatedShimmer()
                    }
                }
            }
        }
    }
}