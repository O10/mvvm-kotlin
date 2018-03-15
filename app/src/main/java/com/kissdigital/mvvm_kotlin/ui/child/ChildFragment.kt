package com.kissdigital.mvvm_kotlin.ui.child

import android.content.Context
import android.os.Bundle
import com.kissdigital.mvvm_kotlin.R
import com.kissdigital.mvvm_kotlin.base.fragment.MvvmFragment
import timber.log.Timber

/**
 * Created by Aleksander Wójcik on 13.03.2018.
 */
class ChildFragment: MvvmFragment<ChildViewModel>() {

    override val viewModelType = ChildViewModel::class.java

    override val layoutId: Int = R.layout.fragment_child

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Timber.d("On attach called for child view model is  ${viewModel} is initialized: ${viewModel.isViewModelInitialized}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("On create called for child view model is  ${viewModel} is initialized: ${viewModel.isViewModelInitialized}")
    }
}