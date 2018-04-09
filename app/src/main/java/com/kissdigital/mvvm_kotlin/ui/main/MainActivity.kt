package com.kissdigital.mvvm_kotlin.ui.main

import android.Manifest
import com.kissdigital.mvvm_kotlin.R
import com.kissdigital.mvvm_kotlin.base.activity.MvvmActivity
import com.tbruyelle.rxpermissions2.RxPermissions
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.kotlin.bindUntilEvent
import dagger.Lazy
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import javax.inject.Inject

class MainActivity : MvvmActivity<MainViewModel>() {

    override val layoutId = R.layout.activity_main
    override val viewModelType = MainViewModel::class.java

    @Inject
    lateinit var rxPermissions: Lazy<RxPermissions>

    override fun onStart() {
        super.onStart()
        rxPermissions.get()
                .request(Manifest.permission.ACCESS_FINE_LOCATION)
                .filter { it }
                .concatMap { viewModel.locationObservable() }
                .bindUntilEvent(this, ActivityEvent.STOP)
                .subscribe({
                    locationText.text = it.toString()
                    Timber.d("Current location $it")
                }, { Timber.e(it, "Error occured") })
    }

}
