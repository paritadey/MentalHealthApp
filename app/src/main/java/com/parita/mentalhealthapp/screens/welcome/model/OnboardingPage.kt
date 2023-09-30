package com.parita.mentalhealthapp.screens.welcome.model

import androidx.annotation.DrawableRes
import com.parita.mentalhealthapp.R

data class OnboardingPage(
    val title: String,
    val stepNumber: Int,
    @DrawableRes val image: Int
)

val onboardPages = listOf(
    OnboardingPage(
        title = "Personalize Your Mental Health State With AI",
        stepNumber = 1,
        image = R.drawable.welcome_step_two
        ),
    OnboardingPage(
        title = "Intelligent Mood Tracking & Emotion Insights",
        stepNumber = 2,
        image = R.drawable.welcome_step_three
        ),
    OnboardingPage(
        title = "Mindful Resources That Makes You Happy",
        stepNumber = 3,
        image = R.drawable.welcome_step_four
    ),
    OnboardingPage(
        title = "Loving & Supportive Community",
        stepNumber = 4,
        image = R.drawable.welcome_step_five
    )
)