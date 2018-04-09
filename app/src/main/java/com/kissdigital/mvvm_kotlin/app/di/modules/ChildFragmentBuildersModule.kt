package com.kissdigital.mvvm_kotlin.app.di.modules

import com.kissdigital.mvvm_kotlin.app.di.scope.ChildFragmentScope
import com.kissdigital.mvvm_kotlin.ui.child.ChildFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Aleksander Wójcik on 13.03.2018.
 */
@Module
abstract class ChildFragmentBuildersModule {

    @ChildFragmentScope
    @ContributesAndroidInjector(modules = [(ChildFragmentViewModelModule::class)])
    abstract fun childFragment(): ChildFragment

}