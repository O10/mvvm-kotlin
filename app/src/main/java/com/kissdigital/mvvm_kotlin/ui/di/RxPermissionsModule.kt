package com.kissdigital.mvvm_kotlin.ui.di

import android.app.Activity
import com.tbruyelle.rxpermissions2.RxPermissions
import dagger.Module
import dagger.Provides

/**
 * Created by O10 on 29.05.2017.
 */
@Module
class RxPermissionsModule(val activity: Activity) {


    @ActivityScope
    @Provides
    fun rxPermissions(): RxPermissions = RxPermissions(activity)
}