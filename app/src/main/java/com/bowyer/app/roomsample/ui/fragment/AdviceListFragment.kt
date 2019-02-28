package com.bowyer.app.roomsample.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bowyer.app.roomsample.RoomApplication
import com.bowyer.app.roomsample.database.AppDatabase
import com.bowyer.app.roomsample.database.entity.Advice
import com.bowyer.app.roomsample.database.entity.AdviceType
import com.bowyer.app.roomsample.databinding.FragmentAdviceListBinding
import com.bowyer.app.roomsample.ui.adapter.AdviceAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class AdviceListFragment : Fragment(), AdviceAdapter.OnClickItemListener {

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

    @Inject
    lateinit var compositeDisposable: CompositeDisposable
    @Inject
    lateinit var appDatabase: AppDatabase
    private lateinit var adviceAdapter: AdviceAdapter
    private lateinit var binding: FragmentAdviceListBinding
    private lateinit var type: AdviceType

    override fun onAttach(context: Context?) {
        RoomApplication.component(context!!).inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAdviceListBinding.inflate(inflater, container, false)
        initRecyclerView()
        initData()
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    private fun initRecyclerView() {
        adviceAdapter = AdviceAdapter(this)
        binding.recycler.apply {
            setHasFixedSize(true)
            adapter = adviceAdapter
        }
    }

    private fun initData() {
        type = arguments?.getSerializable(TYPE) as AdviceType
        appDatabase.adviceDao().getAll()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeBy(
                onSuccess = adviceAdapter::replaceAll,
                onError = Timber::e
            ).addTo(compositeDisposable)

    }


    override fun onCheckChanged(checked: Boolean, advice: Advice) {

    }

    override fun onItemClick(advice: Advice) {

    }
}