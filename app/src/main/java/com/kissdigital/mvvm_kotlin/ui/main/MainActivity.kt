package com.kissdigital.mvvm_kotlin.ui.main

import android.content.Intent
import android.os.Bundle
import com.kissdigital.mvvm_kotlin.R
import com.kissdigital.mvvm_kotlin.base.activity.MvvmActivity
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import javax.inject.Inject

class MainActivity : MvvmActivity<MainViewModel>() {

    companion object {
        var counter: Int = 0
    }

    @Inject
    lateinit var param: String

    override val layoutId = R.layout.activity_main
    override val viewModelType = MainViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("Acitvity on create %s ", param)
        testButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java).apply { putExtra("test", counter++.toString()) })
            finish()
        }
    }

}
