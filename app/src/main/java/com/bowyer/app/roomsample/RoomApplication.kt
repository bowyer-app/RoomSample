package com.bowyer.app.roomsample

import android.app.Application
import timber.log.Timber
import javax.inject.Inject

class RoomApplication : Application() {

    lateinit var appComponent: AppComponent

    @Inject
    lateinit var tree: Timber.Tree

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .roomModule(RoomModule(this))
            .build()

        appComponent.inject(this)
        Timber.plant(tree)
    }
}