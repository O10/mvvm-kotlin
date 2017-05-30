package com.kissdigital.mvvm_kotlin.base.activity

import android.os.Bundle
import com.kissdigital.mvvm_kotlin.app.MyApp
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

/**
 * Created by O10 on 29.05.2017.
 */
abstract class BaseActivity : RxAppCompatActivity() {

    val myApp: MyApp
        get() {
            return application as MyApp
        }

    protected abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        initDagger()
    }

    protected open fun initDagger() {
    }

}