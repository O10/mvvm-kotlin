package com.kissdigital.mvvm_kotlin.ui.child

import android.os.Bundle
import com.kissdigital.mvvm_kotlin.R
import com.kissdigital.mvvm_kotlin.base.fragment.MvvmFragment
import com.trello.rxlifecycle2.android.FragmentEvent
import com.trello.rxlifecycle2.kotlin.bindUntilEvent
import kotlinx.android.synthetic.main.fragment_child.*

/**
 * Created by Aleksander Wójcik on 13.03.2018.
 */
class ChildFragment : MvvmFragment<ChildViewModel>() {

    companion object {
        const val INITIAL_TEXT_PARAM = "initial_text"
    }

    override val viewModelType = ChildViewModel::class.java

    override val layoutId: Int = R.layout.fragment_child


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel
                .presentedText
                .bindUntilEvent(this, FragmentEvent.DESTROY_VIEW)
                .subscribe { text: String -> label.text = text }
    }
}