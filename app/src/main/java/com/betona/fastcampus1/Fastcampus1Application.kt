package com.betona.fastcampus1

import android.app.Application
import android.content.Context

class Fastcampus1Application : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = this
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