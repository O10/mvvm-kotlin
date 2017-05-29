package com.kissdigital.mvvm_kotlin.base.viewmodel

import android.arch.lifecycle.ViewModel
import io.reactivex.subjects.BehaviorSubject

/**
 * Created by O10 on 29.05.2017.
 */
open class BaseViewModel : ViewModel() {

    private val viewModelClearedSubject = BehaviorSubject.create<Any>()

    var isViewModelInitialized = false
        private set

    override fun onCleared() {
        super.onCleared()
        viewModelClearedSubject.onNext(Any())
    }

    fun onInitialized() {
        isViewModelInitialized = true
    }
}