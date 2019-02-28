package com.bowyer.app.roomsample.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bowyer.app.roomsample.R
import com.bowyer.app.roomsample.databinding.ActivityMainBinding
import com.bowyer.app.roomsample.ui.fragment.MainFragment

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initToolbar()
        setFragment()
    }

    private fun initToolbar() {
        binding.toolbar.setTitle(R.string.app_name)
        setSupportActionBar(binding.toolbar)
    }

    private fun setFragment() {
        val ft = supportFragmentManager.beginTransaction()
        ft.add(binding.content.id, MainFragment.newInstance())
        ft.commit()
    }
}
