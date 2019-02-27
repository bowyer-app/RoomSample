package com.bowyer.app.roomsample

import android.app.Application
import android.content.Context
import timber.log.Timber
import javax.inject.Inject

class RoomApplication : Application() {

    companion object {
        fun of(context: Context): RoomApplication {
            return context.applicationContext as RoomApplication
        }

        fun component(context: Context): AppComponent {
            return of(context).appComponent
        }
    }

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