package com.parita.mentalhealthapp.screens.Splash

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.parita.mentalhealthapp.MultiWindowViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashScreenFragment : Fragment() {
    private val splashViewModel: SplashViewModel by viewModels()
    private val multiWindowViewModel: MultiWindowViewModel by viewModels()
    private var multiWindowMode: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                multiWindowViewModel.getMultiWindowMode().observe(viewLifecycleOwner, Observer {
                    multiWindowMode = it
                })
                LoadSplashScreen(multiWindowMode)
            }
        }
    }

    @Composable
    fun LoadSplashScreen(mode: Boolean) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SplashScreen(mode, splashViewModel, findNavController())
        }
    }
}