package com.whitemonkeys.botcreator.networking.model

data class SignInRequest(
    val email: String,
    val password: String,
    val device: String
)