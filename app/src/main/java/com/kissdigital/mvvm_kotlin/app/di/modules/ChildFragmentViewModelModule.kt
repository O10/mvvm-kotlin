package com.kissdigital.mvvm_kotlin.app.di.modules

import android.arch.lifecycle.ViewModel
import com.kissdigital.mvvm_kotlin.app.di.ViewModelKey
import com.kissdigital.mvvm_kotlin.ui.child.ChildFragment
import com.kissdigital.mvvm_kotlin.ui.child.ChildViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Named

/**
 * Created by Aleksander Wójcik on 13.03.2018.
 */
@Module
abstract class ChildFragmentViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ChildViewModel::class)
    abstract fun childViewModel(childViewModel: ChildViewModel): ViewModel

    @Module
    companion object {
        @JvmStatic
        @Provides
        @Named(ChildFragment.INITIAL_TEXT_PARAM)
        fun childFragmentParam(fragment: ChildFragment): String = fragment.arguments?.getString(ChildFragment.INITIAL_TEXT_PARAM)
                ?: "test"
    }
}