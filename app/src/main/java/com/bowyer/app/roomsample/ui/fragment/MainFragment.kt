package com.bowyer.app.roomsample.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bowyer.app.roomsample.databinding.FragmentMainBinding
import com.bowyer.app.roomsample.ui.activity.AdviceRegisterActivity
import com.bowyer.app.roomsample.ui.adapter.AdviceFragmentAdapter
import com.google.android.material.tabs.TabLayout

class MainFragment : Fragment() {

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        initTab()
        binding.fab.setOnClickListener { openRegister() }
        return binding.root
    }

    private fun initTab() {
        binding.adviceViewPager.apply {
            adapter = AdviceFragmentAdapter(context!!, childFragmentManager)
            offscreenPageLimit = 2
        }
        binding.tabs.apply {
            tabMode = TabLayout.MODE_FIXED
            tabGravity = TabLayout.GRAVITY_FILL
            setupWithViewPager(binding.adviceViewPager)
        }
    }

    private fun openRegister() {
        AdviceRegisterActivity.startActivity(activity!!, null)
    }
}