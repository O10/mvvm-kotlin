package com.kissdigital.mvvm_kotlin.base.fragment

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.kissdigital.mvvm_kotlin.base.viewmodel.BaseViewModel
import javax.inject.Inject

/**
 * Created by O10 on 29.05.2017.
 */
abstract class MvvmFragment<T : BaseViewModel> : BaseFragment() {

    protected abstract val viewModelType: Class<T>

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val viewModel: T by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(viewModelType)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!viewModel.isViewModelInitialized) {
            initViewModel()
            viewModel.onInitialized()
        }
    }

    protected fun initViewModel() {}
}