package com.whitemonkeys.botcreator.domain

import com.whitemonkeys.botcreator.networking.AuthClient
import com.whitemonkeys.botcreator.networking.model.AuthResult
import com.whitemonkeys.botcreator.networking.model.SignInRequest
import com.whitemonkeys.botcreator.networking.model.SignUpRequest
import com.whitemonkeys.botcreator.networking.utils.NetworkError
import com.whitemonkeys.botcreator.networking.utils.Result as Result

class AuthRepositoryImpl(
    private val authClient: AuthClient
) : AuthRepository {
    override suspend fun signUp(
        name: String, email: String, password: String, device: String
    ): Result<AuthResult, NetworkError> =
        authClient.signUp(
            SignUpRequest(name, email, password, device)
        )

    override suspend fun signIn(
        email: String, password: String, device: String
    ): Result<AuthResult, NetworkError> =
        authClient.signIn(SignInRequest(email, password, device))
}