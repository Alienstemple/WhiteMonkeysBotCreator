package com.whitemonkeys.botcreator.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.whitemonkeys.botcreator.uikit.black
import com.whitemonkeys.botcreator.uikit.white
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun OnboardingScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = black)) {
        Column {
            Text(text = "Легко оформить  бота в один клик", color = white)
            Button(modifier = Modifier.fillMaxWidth().background(MaterialTheme.colors.primary), onClick = {  }) {
                Text(text = "Попробовать бесплатно", color = white)
            }
        }
    }
}