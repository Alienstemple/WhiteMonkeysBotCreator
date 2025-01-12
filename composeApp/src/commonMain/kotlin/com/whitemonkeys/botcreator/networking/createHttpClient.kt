package com.whitemonkeys.botcreator.networking

import com.whitemonkeys.botcreator.networking.model.AuthResult
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.forms.submitForm
import io.ktor.http.Parameters
import io.ktor.http.auth.HttpAuthHeader
import io.ktor.serialization.kotlinx.json.json

fun createHttpClient(engine: HttpClientEngine): HttpClient {
    return HttpClient(engine) {
        install(Logging) {
            level = LogLevel.ALL
            logger = Logger.SIMPLE
        }
        install(ContentNegotiation) {
            json()
        }
        install(HttpTimeout) {
            requestTimeoutMillis = 5000
        }
        install(Auth) {
            bearer {
                refreshTokens {
                    val refreshTokenInfo: AuthResult =
                        client.submitForm(
                            url = "http://10.0.2.2:8080/api/auth",
                            formParameters = Parameters.build {
                                append("grant_type", "refresh_token")
                                append("client_id", "YOUR_CLIENT_ID")
                                append("refresh_token", "CURRENT_REFRESH_TOKEN")
                            }
                        ) { markAsRefreshTokenRequest() }.body()

                    val accessToken = refreshTokenInfo.accessToken
                    val refreshToken = refreshTokenInfo.refreshToken

                    BearerTokens(accessToken, refreshToken)
                }
            }
        }
    }
}