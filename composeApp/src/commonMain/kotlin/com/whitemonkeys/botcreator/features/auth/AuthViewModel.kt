package com.whitemonkeys.botcreator.features.auth

import androidx.lifecycle.ViewModel
import com.whitemonkeys.botcreator.domain.AuthRepository

class AuthViewModel(
    private val authRepository: AuthRepository
): ViewModel() {
    suspend fun signUp(name: String, email: String, password: String, device: String) {
        authRepository.signUp(name, email, password, device)
    }

    suspend fun signIn(email: String, password: String, device: String) {
        authRepository.signIn(email, password, device)
    }
}