package com.whitemonkeys.botcreator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import com.whitemonkeys.botcreator.networking.AuthClient
import com.whitemonkeys.botcreator.networking.createHttpClient
import com.whitemonkeys.botcreator.onboarding.OnboardingScreen
import io.ktor.client.engine.okhttp.OkHttp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            OnboardingScreen(
                client = remember {
                    AuthClient(createHttpClient(OkHttp.create()))
                })
        }
    }
}