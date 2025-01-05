package com.whitemonkeys.botcreator.di

import com.whitemonkeys.botcreator.domain.AuthRepository
import com.whitemonkeys.botcreator.domain.AuthRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

val sharedModule = module {
    single {
        AuthRepositoryImpl(get())
    }.bind<AuthRepository>()
}

expect val platformModule: Module