package com.bowyer.app.roomsample.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bowyer.app.roomsample.R
import com.bowyer.app.roomsample.RoomApplication
import com.bowyer.app.roomsample.database.AppDatabase
import com.bowyer.app.roomsample.database.entity.Advice
import com.bowyer.app.roomsample.databinding.ActivityAdviceRegisterBinding
import com.bowyer.app.roomsample.util.ext.toEditable
import com.google.android.material.snackbar.Snackbar
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class AdviceRegisterActivity : AppCompatActivity() {
    companion object {
        fun startActivity(context: Context, advice: Advice?) {
            val intent = Intent(context, AdviceRegisterActivity::class.java)
                .apply {
                    putExtra(Advice.KEY, advice)
                }
            context.startActivity(intent)
        }
    }

    private val binding: ActivityAdviceRegisterBinding by lazy {
        DataBindingUtil.setContentView<ActivityAdviceRegisterBinding>(this, R.layout.activity_advice_register)
    }

    @Inject
    lateinit var compositDisposable: CompositeDisposable
    @Inject
    lateinit var appDatabase: AppDatabase
    private var advice: Advice? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        RoomApplication.component(this).inject(this)
        super.onCreate(savedInstanceState)
        initToolBar()
        initData()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositDisposable.clear()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_edit_advice, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.menu_save -> {
                save()
                return true
            }
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return false
    }


    private fun initToolBar() {
        binding.toolbar.setTitle(R.string.title_advice_register)
        setSupportActionBar(binding.toolbar)
        val bar = supportActionBar
        if (bar != null) {
            bar.setDisplayHomeAsUpEnabled(true)
            bar.setDisplayShowHomeEnabled(true)
            bar.setHomeButtonEnabled(true)
        }
    }

    private fun initData() {
        advice = intent.getParcelableExtra(Advice.KEY)
        advice?.let {
            binding.editTitle.text = it.title.toEditable()
            binding.editMemo.text = it.memo.toEditable()
        }
    }

    private fun save() {
        val title = binding.editTitle.text.toString()
        if (title.isEmpty()) {
            Snackbar.make(
                binding.root, R.string.advice_needs_title,
                Snackbar.LENGTH_SHORT
            ).show()
            return
        }

        val memo = binding.editMemo.text.toString()
        if (memo.isEmpty()) {
            Snackbar.make(
                binding.root, R.string.advice_needs_memo,
                Snackbar.LENGTH_SHORT
            ).show()
            return
        }
        if (advice == null) {
            val data = Advice(title = title, memo = memo)
            appDatabase.adviceDao().insert(data)
        } else {
            val data = Advice(id = advice!!.id, title = title, memo = memo)
            appDatabase.adviceDao().update(data)
        }
        finish()
    }
}