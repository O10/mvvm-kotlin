package com.kissdigital.mvvm_kotlin.base.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import com.kissdigital.mvvm_kotlin.app.MyApp
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by O10 on 29.05.2017.
 */
abstract class BaseActivity : RxAppCompatActivity(), HasSupportFragmentInjector {

    val myApp: MyApp
        get() = application as MyApp

    protected abstract val layoutId: Int

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
    }

}