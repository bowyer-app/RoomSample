package com.bowyer.app.roomsample.ui.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.bowyer.app.roomsample.R
import com.bowyer.app.roomsample.database.entity.AdviceType
import com.bowyer.app.roomsample.ui.fragment.AdviceListFragment

class AdviceFragmentAdapter(private val context: Context, fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int {
        return AdviceType.values().size
    }

    override fun getItem(position: Int): Fragment {
        return AdviceListFragment.newInstance(AdviceType.fromPage(position))
    }

    override fun getPageTitle(position: Int): CharSequence? {
        val titleId = when (position) {
            0 -> R.string.not_yet
            1 -> R.string.done
            else -> R.string.all
        }
        return context.getString(titleId)
    }
}