package com.whitemonkeys.botcreator.features.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextDecoration
import com.whitemonkeys.botcreator.uikit.SimpleButton
import com.whitemonkeys.botcreator.uikit.black
import com.whitemonkeys.botcreator.uikit.white
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import whitemonkeysbotcreator.composeapp.generated.resources.Res
import whitemonkeysbotcreator.composeapp.generated.resources.auth_create_account
import whitemonkeysbotcreator.composeapp.generated.resources.auth_hello

@OptIn(KoinExperimentalAPI::class)
@Composable
fun AuthScreen() {
    val viewModel = koinViewModel<AuthViewModel>()

    val hasAccount by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().background(color = black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (!hasAccount) {
            Text(text = stringResource(Res.string.auth_hello), color = white)
            Text(text = stringResource(Res.string.auth_create_account), color = white)
            TextField("Имя", {})
            TextField("Почта", {})
            TextField("Пароль", {})
            SimpleButton(text = "Зарегистрироваться", onClick = {})
            Row {
                Text(text = "Уже есть аккаунт?", color = white)
                ClickableText(
                    text = AnnotatedString(
                        text = "Войти",
                        spanStyle = SpanStyle(
                            textDecoration = TextDecoration.Underline,
                            color = white
                        ),
                    ),
                    onClick = {})
            }
        } else {
            Text(text = "Привет!", color = white)
            Text(text = "Рады видеть тебя снова", color = white)
            TextField("Почта", {})
            TextField("Пароль", {})
            SimpleButton(text = "Войти", onClick = {})
            Row {
                Text(text = "Ещё нет аккаунта?", color = white)
                ClickableText(
                    text = AnnotatedString(
                        text = "Создать",
                        spanStyle = SpanStyle(
                            textDecoration = TextDecoration.Underline,
                            color = white
                        ),
                    ),
                    onClick = {})
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.signUp(
            name = "Admin1",
            email = "admin1@gmail.com",
            password = "AdminAdmin",
            device = "Postman"
        )
    }
}