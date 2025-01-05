package com.whitemonkeys.botcreator

import androidx.compose.ui.window.ComposeUIViewController
import com.whitemonkeys.botcreator.di.initKoin
import com.whitemonkeys.botcreator.features.auth.AuthScreen
import org.koin.compose.KoinContext

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    KoinContext {
        AuthScreen()
    }
}