package com.kissdigital.mvvm_kotlin.app

import android.content.SharedPreferences
import com.kissdigital.mvvm_kotlin.app.di.scope.ApplicationScope
import javax.inject.Inject

/**
 * Created by O10 on 29.05.2017.
 */
@ApplicationScope
class Configuration @Inject constructor(private val sharedPreferences: SharedPreferences)