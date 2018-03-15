package com.kissdigital.mvvm_kotlin.app.di.modules

import com.kissdigital.mvvm_kotlin.app.di.scope.FragmentScope
import com.kissdigital.mvvm_kotlin.ui.clicks.ClickFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Aleksander Wójcik on 26.01.2018.
 */
@Module
abstract class FragmentBuildersModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = arrayOf(FragmentModule::class, FragmentViewModelModule::class, ChildFragmentBuildersModule::class))
    abstract fun clicksFragment(): ClickFragment

}