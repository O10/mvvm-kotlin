package com.kissdigital.mvvm_kotlin.base.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kissdigital.mvvm_kotlin.app.MyApp
import com.trello.rxlifecycle2.components.support.RxFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by O10 on 29.05.2017.
 */
abstract class BaseFragment : RxFragment(), HasSupportFragmentInjector {

    @Inject
    lateinit var childFragmentInjector: DispatchingAndroidInjector<Fragment>

    val myApp: MyApp
        get() = activity?.application as MyApp

    protected abstract val layoutId: Int

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = childFragmentInjector

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        LayoutInflater.from(context).inflate(layoutId, container, false)

}