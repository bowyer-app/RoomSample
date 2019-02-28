package com.bowyer.app.roomsample.ui.adapter

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bowyer.app.roomsample.database.entity.Advice
import com.bowyer.app.roomsample.databinding.AdviceListItemBinding

class AdviceAdapter(private val onClickItemListener: OnClickItemListener) :
    RecyclerView.Adapter<AdviceAdapter.ItemViewHolder>() {

    private var dataList: ArrayList<Advice> = ArrayList()

    interface OnClickItemListener {
        fun onItemClick(advice: Advice)
        fun onCheckChanged(checked: Boolean, advice: Advice)
    }

    fun replaceAll(data: List<Advice>) {
        this.dataList = ArrayList(data)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return this.dataList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdviceListItemBinding.inflate(inflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val binding = holder.binding
        val advice = dataList[position]
        binding.adviceTitle.text = advice.title
        binding.adviceText.text = advice.memo
        binding.defaultCheck.isChecked = advice.done
        binding.root.setOnClickListener { onClickItemListener.onItemClick(advice) }
        binding.defaultCheck.setOnClickListener {
            onClickItemListener.onCheckChanged(advice.done, advice)
        }
        binding.allow.setOnClickListener { allowClick(binding) }

    }

    private fun allowClick(binding: AdviceListItemBinding) {
        val adviceTextAll = binding.adviceText
        if (adviceTextAll.visibility == View.GONE) {
            adviceTextAll.visibility = View.VISIBLE
            binding.adviceText.visibility = View.GONE
            val rotateUpAnim = ObjectAnimator.ofPropertyValuesHolder(binding.allow,
                PropertyValuesHolder.ofFloat(View.ROTATION, 0f, 180f))
            rotateUpAnim.duration = 250L
            rotateUpAnim.start()
        } else {
            adviceTextAll.visibility = View.GONE
            binding.adviceText.visibility = View.VISIBLE
            val rotateDownAnim = ObjectAnimator.ofPropertyValuesHolder(binding.allow,
                PropertyValuesHolder.ofFloat(View.ROTATION, 180f, 0f))
            rotateDownAnim.duration = 250L
            rotateDownAnim.start()
        }
    }

    class ItemViewHolder(var binding: AdviceListItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}