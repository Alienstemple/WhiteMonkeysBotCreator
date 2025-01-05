package com.whitemonkeys.botcreator

import android.app.Application
import com.whitemonkeys.botcreator.di.initKoin
import org.koin.android.ext.koin.androidContext

class BotPackApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@BotPackApplication)
        }
    }
}