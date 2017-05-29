package com.kissdigital.mvvm_kotlin.ui.clicks

import android.os.Bundle
import com.jakewharton.rxbinding2.view.RxView
import com.kissdigital.mvvm_kotlin.R
import com.kissdigital.mvvm_kotlin.base.fragment.MvvmFragment
import com.trello.rxlifecycle2.kotlin.bindToLifecycle
import kotlinx.android.synthetic.main.fragment_clicks.*

/**
 * Created by O10 on 29.05.2017.
 */
class ClickFragment : MvvmFragment<ClicksViewModel>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        RxView.clicks(buttonClicks).subscribe() { viewModel.buttonClicked() }
        viewModel.clicksObservable.bindToLifecycle(this).subscribe { clicksNum.text = it.toString() }
    }

    override fun getLayoutId(): Int = R.layout.fragment_clicks

    override fun getViewModelType(): Class<ClicksViewModel> = ClicksViewModel::class.java
}