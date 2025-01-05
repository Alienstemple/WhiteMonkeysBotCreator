package com.whitemonkeys.botcreator.di

import com.whitemonkeys.botcreator.features.auth.AuthViewModel
import com.whitemonkeys.botcreator.networking.AuthClient
import com.whitemonkeys.botcreator.networking.createHttpClient
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

actual val platformModule = module {
    single {
        AuthClient(createHttpClient(OkHttp.create()))
    }.bind<AuthClient>()
    viewModelOf(::AuthViewModel)
}