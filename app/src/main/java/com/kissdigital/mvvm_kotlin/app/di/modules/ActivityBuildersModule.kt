package com.kissdigital.mvvm_kotlin.app.di.modules

import com.kissdigital.mvvm_kotlin.ui.di.RxPermissionsModule
import com.kissdigital.mvvm_kotlin.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Aleksander Wójcik on 07.11.2017.
 */
@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector()
    abstract fun contributeMainActivity(): MainActivity
}