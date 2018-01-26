package com.kissdigital.mvvm_kotlin.ui.main

import com.kissdigital.mvvm_kotlin.R
import com.kissdigital.mvvm_kotlin.base.activity.MvvmActivity

class MainActivity : MvvmActivity<MainViewModel>() {

    override val layoutId = R.layout.activity_main
    override val viewModelType = MainViewModel::class.java

}
