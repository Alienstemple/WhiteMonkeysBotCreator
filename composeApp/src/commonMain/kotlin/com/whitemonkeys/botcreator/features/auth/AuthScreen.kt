package com.whitemonkeys.botcreator.features.auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun AuthScreen() {
    val viewModel = koinViewModel<AuthViewModel>()

    LaunchedEffect(Unit) {
        viewModel.signUp(
            name = "Admin1",
            email = "admin1@gmail.com",
            password = "AdminAdmin",
            device = "Postman"
        )
    }
}