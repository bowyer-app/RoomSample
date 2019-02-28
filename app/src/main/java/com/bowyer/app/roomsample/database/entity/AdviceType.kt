package com.bowyer.app.roomsample.database.entity

enum class AdviceType(val type: Int) {
    ALL(0),
    NOT_YET(1),
    DONE(2);

    companion object {
        fun of(type: Int): AdviceType =
            when (type) {
                1 -> NOT_YET
                2 -> DONE
                else -> ALL
            }

        fun fromPage(page: Int): AdviceType =
            when (page) {
                1 -> NOT_YET
                2 -> DONE
                else -> ALL
            }
    }
}