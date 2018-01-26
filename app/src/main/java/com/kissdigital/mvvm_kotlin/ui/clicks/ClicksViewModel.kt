package com.kissdigital.mvvm_kotlin.ui.clicks

import com.kissdigital.mvvm_kotlin.base.viewmodel.BaseViewModel
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

/**
 * Created by O10 on 29.05.2017.
 */
class ClicksViewModel @Inject constructor() : BaseViewModel() {

    private val clicksSubject: BehaviorSubject<Int> = BehaviorSubject.createDefault(0)

    val clicksObservable: Observable<Int>
        get() = clicksSubject.hide()

    fun buttonClicked() {
        clicksSubject.onNext(clicksSubject.value + 1)
    }
}