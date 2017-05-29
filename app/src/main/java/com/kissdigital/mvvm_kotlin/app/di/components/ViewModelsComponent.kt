package com.kissdigital.mvvm_kotlin.app.di.components

import com.kissdigital.mvvm_kotlin.ui.clicks.ClicksViewModel
import com.kissdigital.mvvm_kotlin.ui.main.MainViewModel
import dagger.Subcomponent

/**
 * Created by O10 on 29.05.2017.
 */
@Subcomponent
interface ViewModelsComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): ViewModelsComponent
    }

    fun mainViewModel(): MainViewModel
    fun clicksViewModel(): ClicksViewModel

}