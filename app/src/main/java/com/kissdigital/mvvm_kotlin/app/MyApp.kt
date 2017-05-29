package com.kissdigital.mvvm_kotlin.app

import android.app.Application
import com.kissdigital.mvvm_kotlin.BuildConfig
import com.kissdigital.mvvm_kotlin.app.di.components.DaggerAppComponent
import com.kissdigital.mvvm_kotlin.app.di.modules.AppModule
import timber.log.Timber

/**
 * Created by O10 on 29.05.2017.
 */
class MyApp : Application() {

    val appComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        initTimber()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}