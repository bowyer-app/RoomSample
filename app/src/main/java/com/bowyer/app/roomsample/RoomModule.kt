package com.bowyer.app.roomsample

import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import timber.log.Timber

@Module
class RoomModule(private val application: RoomApplication) {

    @Provides
    fun provideRoomApplication(): RoomApplication = application

    @Provides
    @Singleton
    fun provideTimberTree(): Timber.Tree = Timber.DebugTree()
}