package com.kissdigital.mvvm_kotlin.ui.main

import com.kissdigital.mvvm_kotlin.app.di.components.AppComponent
import com.kissdigital.mvvm_kotlin.ui.di.ActivityScope
import com.kissdigital.mvvm_kotlin.ui.di.RxPermissionsModule
import dagger.Component

/**
 * Created by O10 on 29.05.2017.
 */
@ActivityScope
@Component(modules = arrayOf(RxPermissionsModule::class), dependencies = arrayOf(AppComponent::class))
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}