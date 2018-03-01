package com.kissdigital.mvvm_kotlin.app.di.modules

import android.os.Bundle
import android.support.v4.app.Fragment
import com.kissdigital.mvvm_kotlin.app.di.qualifier.FragmentBundle
import com.kissdigital.mvvm_kotlin.ui.clicks.ClickFragment
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 * Created by Aleksander Wójcik on 01.03.2018.
 */

@Module
abstract class FragmentModule {

    @Binds
    abstract fun fragment(fragment: ClickFragment): Fragment

    @Module
    companion object {

        @JvmStatic
        @FragmentBundle
        @Provides
        fun bundle(fragment: Fragment): Bundle = fragment.arguments ?: Bundle.EMPTY
    }
}