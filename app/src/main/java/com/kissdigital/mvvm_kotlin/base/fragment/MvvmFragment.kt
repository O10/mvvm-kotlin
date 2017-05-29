package com.kissdigital.mvvm_kotlin.base.fragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.kissdigital.mvvm_kotlin.base.viewmodel.BaseViewModel

/**
 * Created by O10 on 29.05.2017.
 */
abstract class MvvmFragment<T : BaseViewModel> : BaseFragment() {

    val viewModel: T by lazy {
        ViewModelProviders.of(this, myApp.appComponent.factory()).get(getViewModelType())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!viewModel.isViewModelInitialized) {
            initViewModel()
            viewModel.onInitialized()
        }
    }

    protected abstract fun getViewModelType(): Class<T>

    protected fun initViewModel() {}
}