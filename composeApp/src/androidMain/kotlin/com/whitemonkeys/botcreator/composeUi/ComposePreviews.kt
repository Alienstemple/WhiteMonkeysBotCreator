package com.whitemonkeys.botcreator.composeUi

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.whitemonkeys.botcreator.uikit.SimpleButton

@Composable
@Preview
fun SimpleButtonPreview() {
    SimpleButton(modifier = Modifier, text = "Зарегистрироваться") {}
}