package com.renclav.samplecalendarbooking

import android.app.Application
import com.airbnb.mvrx.Mavericks
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber


@HiltAndroidApp
class DemoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(this)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}