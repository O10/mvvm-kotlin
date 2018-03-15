package com.kissdigital.mvvm_kotlin.ui.main

import com.kissdigital.mvvm_kotlin.R
import com.kissdigital.mvvm_kotlin.base.activity.MvvmActivity
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.kotlin.bindUntilEvent
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : MvvmActivity<MainViewModel>() {

    override val layoutId = R.layout.activity_main
    override val viewModelType = MainViewModel::class.java

    override fun onStart() {
        super.onStart()
        viewModel.locationObservable()
                .bindUntilEvent(this, ActivityEvent.STOP)
                .map { Pair(System.currentTimeMillis(), it) }
                .buffer(2, 1)
                .doOnNext { Timber.d("Lag is ${it[1].first - it[0].first} ms") }
                .map { it.last().second }
                .subscribe {
                    locationText.text = it.toString()
                    Timber.d("Current location $it")
                }
    }

}
