package com.bowyer.app.roomsample.database

import android.app.Application
import androidx.room.Room
import com.bowyer.app.roomsample.database.dao.AdviceDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {
    @Provides
    @Singleton
    internal fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java,
            "room_sample_db")
            .build()
    }

    @Provides
    @Singleton
    internal fun provideAdviceDao(appDatabase: AppDatabase):AdviceDao{
        return appDatabase.adviceDao()
    }

}