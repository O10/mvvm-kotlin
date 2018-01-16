package com.kissdigital.mvvm_kotlin.app.di.components

import android.arch.lifecycle.ViewModelProvider
import com.kissdigital.mvvm_kotlin.app.Configuration
import com.kissdigital.mvvm_kotlin.app.MyApp
import com.kissdigital.mvvm_kotlin.app.di.ApplicationScope
import com.kissdigital.mvvm_kotlin.app.di.modules.AppModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import pl.charmas.android.reactivelocation.ReactiveLocationProvider

/**
 * Created by O10 on 29.05.2017.
 */
@ApplicationScope
@Component(modules = arrayOf(AndroidInjectionModule::class, AppModule::class))
interface AppComponent: AndroidInjector<MyApp> {

    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<MyApp>()
}