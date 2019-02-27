package com.bowyer.app.roomsample.database

import androidx.room.TypeConverter

internal class RoomTypeConverter {
    @TypeConverter
    fun fromIntToBoolean(value: Int) = value == 1
}