package com.bowyer.app.roomsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bowyer.app.roomsample.databinding.ActivityMainBinding
import com.bowyer.app.roomsample.ui.activity.AdviceRegisterActivity

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RoomApplication.component(this).inject(this)
        binding.fab.setOnClickListener {
            AdviceRegisterActivity.startActivity(this, null)
        }
    }
}
