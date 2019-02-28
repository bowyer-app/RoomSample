package com.bowyer.app.roomsample.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Advice(
    @PrimaryKey
    @ColumnInfo(name = ID)
    var id: Long = 0,

    @ColumnInfo(name = TITLE)
    var title: String = "",

    @ColumnInfo(name = MEMO)
    var memo: String = "",

    @ColumnInfo(name = DONE)
    var done: Boolean = false
) : Parcelable {
    companion object {
        const val KEY = "key_advice"
        const val TABLE = "advice"
        const val ID = "id"
        const val TITLE = "title"
        const val MEMO = "memo"
        const val DONE = "done"
    }

}