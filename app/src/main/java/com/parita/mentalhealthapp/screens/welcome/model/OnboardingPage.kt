package com.parita.mentalhealthapp.screens.welcome.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.parita.mentalhealthapp.R
import com.parita.mentalhealthapp.ui.theme.step1Green
import com.parita.mentalhealthapp.ui.theme.step2Brown
import com.parita.mentalhealthapp.ui.theme.step3Yellow
import com.parita.mentalhealthapp.ui.theme.step4Blue

data class OnboardingPage(
    val background: Color,
    val title: String,
    val stepNumber: Int,
    @DrawableRes val image: Int
)

val onboardPages = listOf(
    OnboardingPage(
        background = step1Green,
        title = "Personalize Your Mental Health State With AI",
        stepNumber = 1,
        image = R.drawable.welcome_step_two
        ),
    OnboardingPage(
        background = step2Brown,
        title = "Intelligent Mood Tracking & Emotion Insights",
        stepNumber = 2,
        image = R.drawable.welcome_step_three
        ),
    OnboardingPage(
        background = step3Yellow,
        title = "Mindful Resources That Makes You Happy",
        stepNumber = 3,
        image = R.drawable.welcome_step_four
    ),
    OnboardingPage(
        background = step4Blue,
        title = "Loving & Supportive Community",
        stepNumber = 4,
        image = R.drawable.welcome_step_five
    )
)