package com.kissdigital.mvvm_kotlin.app.di.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.kissdigital.mvvm_kotlin.app.di.MyViewModelFactory
import com.kissdigital.mvvm_kotlin.app.di.ViewModelKey
import com.kissdigital.mvvm_kotlin.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Aleksander Wójcik on 24.01.2018.
 * Module creating view models and arguments - probably needs seperation as app grows
 */
@Module
abstract class ActivityViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun mainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: MyViewModelFactory): ViewModelProvider.Factory

}