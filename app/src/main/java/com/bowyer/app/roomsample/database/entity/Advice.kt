package com.bowyer.app.roomsample.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Advice {
    companion object {
        const val TABLE = "advice"
        const val ID = "id"
        const val TITLE = "title"
        const val MEMO = "memo"
        const val DONE = "done"
    }

    @PrimaryKey
    @ColumnInfo(name = ID)
    var id: Long = 0

    @ColumnInfo(name = TITLE)
    var title: String = ""

    @ColumnInfo(name = MEMO)
    var memo: String = ""

    @ColumnInfo(name = DONE)
    var done: Boolean = false
}