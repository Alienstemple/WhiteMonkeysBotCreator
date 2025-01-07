package com.whitemonkeys.botcreator.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SimpleButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) {
    Box(
        modifier = modifier.then(
            Modifier
                .background(color = purple, shape = RoundedCornerShape(24.dp))
                .padding(vertical = 8.dp, horizontal = 20.dp)
                .clickable(onClick = onClick)
        ),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text, color = white, style = TextStyle(fontWeight = FontWeight.Bold))
    }
}