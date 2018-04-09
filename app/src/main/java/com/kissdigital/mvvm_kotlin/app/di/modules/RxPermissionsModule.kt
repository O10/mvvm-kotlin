package com.kissdigital.mvvm_kotlin.app.di.modules

import android.app.Activity
import com.tbruyelle.rxpermissions2.RxPermissions
import dagger.Module
import dagger.Provides

/**
 * Created by O10 on 29.05.2017.
 */
@Module
abstract class RxPermissionsModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun rxPermissions(activity: Activity): RxPermissions = RxPermissions(activity)
    }

}