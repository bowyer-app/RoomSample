package com.bowyer.app.roomsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bowyer.app.roomsample.database.AppDatabase
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var appDatabase: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RoomApplication.component(this).inject(this)
        setContentView(R.layout.activity_main)
    }
}
