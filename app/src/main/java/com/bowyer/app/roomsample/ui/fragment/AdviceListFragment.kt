package com.bowyer.app.roomsample.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bowyer.app.roomsample.database.entity.AdviceType
import com.bowyer.app.roomsample.databinding.FragmentAdviceListBinding

class AdviceListFragment : Fragment() {

    companion object {
        private const val TYPE = "type"
        fun newInstance(type: AdviceType): AdviceListFragment {
            return AdviceListFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(TYPE, type)
                }
            }
        }
    }

    private lateinit var binding: FragmentAdviceListBinding
    private lateinit var type: AdviceType

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAdviceListBinding.inflate(inflater, container, false)
        initData()
        return binding.root
    }

    private fun initData() {
        type = arguments?.getSerializable(TYPE) as AdviceType
        binding.type.text = type.name
    }
}