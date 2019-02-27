package com.bowyer.app.roomsample.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bowyer.app.roomsample.database.dao.AdviceDao
import com.bowyer.app.roomsample.database.entity.AdviceEntity

@Database(entities = [AdviceEntity::class], version = 1)

@TypeConverters(RoomTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun adviceDao(): AdviceDao
}