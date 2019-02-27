package com.bowyer.app.roomsample

import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RoomModule::class]
)

interface AppComponent : AndroidInjector<RoomApplication> {

    fun inject(activity: MainActivity)
}