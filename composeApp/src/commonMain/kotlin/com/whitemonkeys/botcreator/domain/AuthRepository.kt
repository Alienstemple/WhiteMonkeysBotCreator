package com.whitemonkeys.botcreator.domain

import com.whitemonkeys.botcreator.networking.model.AuthResult
import com.whitemonkeys.botcreator.networking.utils.NetworkError
import com.whitemonkeys.botcreator.networking.utils.Result

interface AuthRepository {
    suspend fun signUp(
        name: String, email: String, password: String, device: String
    ): Result<AuthResult, NetworkError>

    suspend fun signIn(
        email: String, password: String, device: String
    ): Result<AuthResult, NetworkError>
}