package com.kissdigital.mvvm_kotlin.ui.main

import android.Manifest
import com.kissdigital.mvvm_kotlin.R
import com.kissdigital.mvvm_kotlin.base.activity.MvvmActivity
import com.kissdigital.mvvm_kotlin.ui.di.RxPermissionsModule
import com.tbruyelle.rxpermissions2.RxPermissions
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.kotlin.bindUntilEvent
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import javax.inject.Inject

class MainActivity : MvvmActivity<MainViewModel>() {

    @Inject
    lateinit internal var rxPermissions: RxPermissions

    override fun initDagger() {
        DaggerMainActivityComponent.builder()
                .appComponent(myApp.appComponent)
                .rxPermissionsModule(RxPermissionsModule(this))
                .build().inject(this)
    }

    override fun onStart() {
        super.onStart()

        rxPermissions.request(Manifest.permission.ACCESS_FINE_LOCATION)
                .filter { it }.flatMap { _ -> viewModel.locationObservable() }
                .bindUntilEvent(lifecycle(), ActivityEvent.STOP)
                .subscribe({ location ->
                    mainText.text = location.toString()
                }, { throwable -> Timber.e(throwable) })
    }

    override fun getViewModelType(): Class<MainViewModel> = MainViewModel::class.java
    override fun getLayoutId(): Int = R.layout.activity_main
}
