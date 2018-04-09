package com.kissdigital.mvvm_kotlin.ui.clicks

import android.os.Bundle
import android.view.View
import com.jakewharton.rxbinding2.view.RxView
import com.kissdigital.mvvm_kotlin.R
import com.kissdigital.mvvm_kotlin.base.fragment.MvvmFragment
import com.kissdigital.mvvm_kotlin.ui.child.ChildFragment
import com.trello.rxlifecycle2.kotlin.bindToLifecycle
import kotlinx.android.synthetic.main.fragment_clicks.*

/**
 * Created by O10 on 29.05.2017.
 */
class ClickFragment : MvvmFragment<ClicksViewModel>() {

    companion object {
        const val PAR_CLICKS_INITIAL_NUMBER = "initial_clicks"
        const val CHILD_FRAGMENT_TAG = "child_fragment"
    }

    override val layoutId = R.layout.fragment_clicks
    override val viewModelType = ClicksViewModel::class.java

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        RxView.clicks(buttonClicks).subscribe { viewModel.buttonClicked() }
        viewModel.clicksObservable.bindToLifecycle(this).subscribe { clicksNum.text = it.toString() }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (childFragmentManager.findFragmentByTag(CHILD_FRAGMENT_TAG) == null) {
            childFragmentManager.beginTransaction().replace(R.id.childFragmentFrame, ChildFragment(), CHILD_FRAGMENT_TAG).commit()
        }
    }
    
}