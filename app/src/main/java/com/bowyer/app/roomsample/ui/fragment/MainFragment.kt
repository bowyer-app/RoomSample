package com.bowyer.app.roomsample.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bowyer.app.roomsample.databinding.FragmentMainBinding
import com.bowyer.app.roomsample.ui.activity.AdviceRegisterActivity

class MainFragment : Fragment() {

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.fab.setOnClickListener { openRegister() }
        return binding.root
    }

    fun openRegister() {
        AdviceRegisterActivity.startActivity(activity!!, null)
    }

}