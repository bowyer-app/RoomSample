package com.bowyer.app.roomsample

import android.app.Application
import android.content.Context
import com.bowyer.app.roomsample.database.DbModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import timber.log.Timber

@Module(includes = [DbModule::class])
class RoomModule(private val application: RoomApplication) {

    @Provides
    fun provideApplicationContext(): Context = application

    @Provides
    fun provideAppication(): Application = application

    @Provides
    fun provideRoomApplication(): RoomApplication = application

    @Provides
    @Singleton
    fun provideTimberTree(): Timber.Tree = Timber.DebugTree()
}