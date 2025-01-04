package com.whitemonkeys.botcreator

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.whitemonkeys.botcreator.networking.AuthClient
import com.whitemonkeys.botcreator.networking.createHttpClient
import com.whitemonkeys.botcreator.onboarding.OnboardingScreen
import io.ktor.client.engine.darwin.Darwin

fun MainViewController() = ComposeUIViewController {
    OnboardingScreen(
        client = remember {
            AuthClient(createHttpClient(Darwin.create()))
        })
}