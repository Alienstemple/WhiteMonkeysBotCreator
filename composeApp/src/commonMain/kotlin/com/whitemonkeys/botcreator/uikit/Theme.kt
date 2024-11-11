package com.whitemonkeys.botcreator.uikit

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidedValue

@Composable
fun BotPackTheme(
    vararg values: ProvidedValue<*>,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(values = values) {
        MaterialTheme(
            shapes = MaterialTheme.shapes,
            content = content
        )
    }
}