package com.kissdigital.mvvm_kotlin.app.di.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.kissdigital.mvvm_kotlin.app.di.MyViewModelFactory
import com.kissdigital.mvvm_kotlin.app.di.ViewModelKey
import com.kissdigital.mvvm_kotlin.app.di.scope.ApplicationScope
import com.kissdigital.mvvm_kotlin.ui.clicks.ClicksViewModel
import com.kissdigital.mvvm_kotlin.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Aleksander Wójcik on 24.01.2018.
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ClicksViewModel::class)
    abstract fun clicksViewModel(mainViewModel: ClicksViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun mainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @ApplicationScope
    abstract fun bindViewModelFactory(factory: MyViewModelFactory): ViewModelProvider.Factory

}