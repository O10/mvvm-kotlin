package com.kissdigital.mvvm_kotlin.ui.child

import com.kissdigital.mvvm_kotlin.base.viewmodel.BaseViewModel
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by Aleksander Wójcik on 13.03.2018.
 */
class ChildViewModel @Inject constructor(@Named(ChildFragment.INITIAL_TEXT_PARAM) private val usedText: String) : BaseViewModel() {

    val presentedText: Single<String> = Single.just(usedText)

}