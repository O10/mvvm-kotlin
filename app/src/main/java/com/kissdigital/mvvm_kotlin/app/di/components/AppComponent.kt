package com.kissdigital.mvvm_kotlin.app.di.components

import com.kissdigital.mvvm_kotlin.app.MyApp
import com.kissdigital.mvvm_kotlin.app.di.modules.ActivityBuildersModule
import com.kissdigital.mvvm_kotlin.app.di.modules.AppModule
import com.kissdigital.mvvm_kotlin.app.di.modules.ViewModelModule
import com.kissdigital.mvvm_kotlin.app.di.scope.ApplicationScope
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

/**
 * Created by O10 on 29.05.2017.
 */
@ApplicationScope
@Component(modules = arrayOf(AndroidInjectionModule::class,
        AppModule::class,
        ActivityBuildersModule::class,
        ViewModelModule::class))
interface AppComponent : AndroidInjector<MyApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MyApp>()
    
}