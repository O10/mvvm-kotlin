package com.kissdigital.mvvm_kotlin.app.di.modules

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.kissdigital.mvvm_kotlin.app.MyApp
import com.kissdigital.mvvm_kotlin.app.di.scope.ApplicationScope
import dagger.Binds
import dagger.Module
import dagger.Provides
import pl.charmas.android.reactivelocation.ReactiveLocationProvider

/**
 * Created by O10 on 29.05.2017.
 */
@Module
abstract class AppModule {

    @Binds
    abstract fun application(myApp: MyApp): Application

    @Module
    companion object {

        @JvmStatic
        @Provides
        @ApplicationScope
        fun reactiveLocation(application: Application): ReactiveLocationProvider = ReactiveLocationProvider(application)

        @Provides
        @ApplicationScope
        @JvmStatic
        fun sharedPreferences(application: Application): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(application)
    }

}