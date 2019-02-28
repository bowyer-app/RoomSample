package com.bowyer.app.roomsample.util.ext

import android.text.Editable

fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)
