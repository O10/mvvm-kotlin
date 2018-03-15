package com.kissdigital.mvvm_kotlin.app.di.modules

import android.arch.lifecycle.ViewModel
import android.os.Bundle
import com.kissdigital.mvvm_kotlin.app.di.ViewModelKey
import com.kissdigital.mvvm_kotlin.app.di.qualifier.FragmentBundle
import com.kissdigital.mvvm_kotlin.ui.clicks.ClickFragment
import com.kissdigital.mvvm_kotlin.ui.clicks.ClicksViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Named

/**
 * Created by Aleksander Wójcik on 01.03.2018.
 */
@Module
abstract class FragmentViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ClicksViewModel::class)
    abstract fun clicksViewModel(mainViewModel: ClicksViewModel): ViewModel

    @Module
    companion object {
        @JvmStatic
        @Provides
        @Named(ClickFragment.PAR_CLICKS_INITIAL_NUMBER)
        fun someParam(@FragmentBundle bundle: Bundle): Int = bundle.getInt(ClickFragment.PAR_CLICKS_INITIAL_NUMBER, 10)
    }

}