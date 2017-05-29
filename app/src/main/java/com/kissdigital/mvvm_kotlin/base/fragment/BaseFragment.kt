package com.kissdigital.mvvm_kotlin.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kissdigital.mvvm_kotlin.app.MyApp
import com.trello.rxlifecycle2.components.support.RxFragment

/**
 * Created by O10 on 29.05.2017.
 */
abstract class BaseFragment : RxFragment() {

    val myApp: MyApp
        get() {
            return activity.application as MyApp
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDagger()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(getLayoutId(), container, false)
    }

    protected abstract fun getLayoutId(): Int

    protected open fun initDagger() {

    }

}