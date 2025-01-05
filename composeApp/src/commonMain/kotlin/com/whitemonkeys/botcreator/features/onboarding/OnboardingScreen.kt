package com.whitemonkeys.botcreator.features.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.whitemonkeys.botcreator.networking.AuthClient
import com.whitemonkeys.botcreator.networking.model.SignUpRequest
import com.whitemonkeys.botcreator.networking.utils.onError
import com.whitemonkeys.botcreator.networking.utils.onSuccess
import com.whitemonkeys.botcreator.uikit.black
import com.whitemonkeys.botcreator.uikit.white
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun OnboardingScreen(client: AuthClient) {
    val text = remember {
        mutableStateOf("Пока пусто")
    }
    val scope = rememberCoroutineScope()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = black)
    ) {
        Column {
            Text(text = "Легко оформить  бота в один клик", color = white)
            Button(modifier = Modifier.fillMaxWidth().background(MaterialTheme.colors.primary),
                onClick = {
                    scope.launch {
                        client.signUp(
                            SignUpRequest(
                                name = "Admin1",
                                email = "admin1@gmail.com",
                                password = "AdminAdmin",
                                device = "Postman"
                            )
                        )
                            .onSuccess {
                                text.value = it.accessToken + " " + it.refreshToken
                            }
                            .onError {
                                text.value = it.name
                            }
                    }
                }) {
                Text(text = "Попробовать бесплатно", color = white)
            }
            Text(text = text.value, color = white)
        }
    }
}