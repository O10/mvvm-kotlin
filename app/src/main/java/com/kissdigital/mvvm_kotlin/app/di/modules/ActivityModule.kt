package com.kissdigital.mvvm_kotlin.app.di.modules

import android.app.Activity
import android.os.Bundle
import com.kissdigital.mvvm_kotlin.ui.main.MainActivity
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 * Created by Aleksander Wójcik on 25.01.2018.
 */
@Module
abstract class ActivityModule {

    @Binds
    abstract fun activity(activity: MainActivity): Activity

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun bundle(activity: Activity): Bundle = activity.intent.extras ?: Bundle.EMPTY

        @JvmStatic
        @Provides
        fun someParam(bundle: Bundle): String = bundle.getString("test", "1")

    }
}