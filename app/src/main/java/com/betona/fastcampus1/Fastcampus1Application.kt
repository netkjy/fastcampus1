package com.betona.fastcampus1

import android.app.Application
import android.content.Context
import com.betona.fastcampus1.di.appModule
import org.koin.core.context.startKoin

class Fastcampus1Application : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = this

        startKoin {
            modules(appModule)
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        appContext = this
    }

    companion object {
        var appContext: Context? = null
            private set
    }
}