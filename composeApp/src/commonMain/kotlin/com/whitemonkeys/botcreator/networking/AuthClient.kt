package com.whitemonkeys.botcreator.networking

import com.whitemonkeys.botcreator.networking.model.AuthResult
import com.whitemonkeys.botcreator.networking.model.SignInRequest
import com.whitemonkeys.botcreator.networking.model.SignUpRequest
import com.whitemonkeys.botcreator.networking.utils.NetworkError
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.coroutines.TimeoutCancellationException
import com.whitemonkeys.botcreator.networking.utils.Result as Result

class AuthClient(private val httpClient: HttpClient) {
    suspend fun signUp(signUpRequest: SignUpRequest): Result<AuthResult, NetworkError> {
        return processRequest<AuthResult> {
            httpClient.post(
                urlString = BASE_URL + SIGNUP_URL
            ) {
                contentType(ContentType.Application.Json)
                setBody(signUpRequest)
            }
        }
    }

    suspend fun signIn(signInRequest: SignInRequest): Result<AuthResult, NetworkError> {
        return processRequest<AuthResult> {
            httpClient.post(
                urlString = BASE_URL + SIGNIN_URL
            ) {
                contentType(ContentType.Application.Json)
                setBody(signInRequest)
            }
        }
    }

    private suspend inline fun <reified T> processRequest(doRequest: () -> HttpResponse): Result<T, NetworkError> {
        val response = try {
            doRequest.invoke()
        } catch (e: UnresolvedAddressException) {
            return Result.Error(NetworkError.NO_INTERNET)
        } catch (e: TimeoutCancellationException) {
            return Result.Error(NetworkError.REQUEST_TIMEOUT)
        } catch (e: Exception) {
            return Result.Error(NetworkError.UNKNOWN)
        }

        return when(response.status.value) {
            in 200..299 -> {
                val authResult = response.body<T>()
                Result.Success(authResult)
            }
            in 400..499 -> {
                Result.Error(NetworkError.CLIENT_ERROR)
            }
            in 500..599 -> {
                Result.Error(NetworkError.SERVER_ERROR)
            }
            else -> {
                return Result.Error(NetworkError.UNKNOWN)
            }
        }
    }

    companion object {
        private const val BASE_URL = "http://10.0.2.2:8080/api/auth"
        private const val SIGNIN_URL = "/signin"
        private const val SIGNUP_URL = "/signup"
    }
}