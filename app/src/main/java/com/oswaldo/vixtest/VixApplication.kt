package com.oswaldo.vixtest

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class VixApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}