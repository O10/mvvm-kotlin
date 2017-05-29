package com.kissdigital.mvvm_kotlin.app.di.modules

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.kissdigital.mvvm_kotlin.app.MyViewModelFactory
import com.kissdigital.mvvm_kotlin.app.di.ApplicationScope
import com.kissdigital.mvvm_kotlin.app.di.components.ViewModelsComponent
import dagger.Module
import dagger.Provides
import pl.charmas.android.reactivelocation.ReactiveLocationProvider

/**
 * Created by O10 on 29.05.2017.
 */
@Module(subcomponents = arrayOf(ViewModelsComponent::class))
class AppModule(val context: Context) {

    @Provides
    @ApplicationScope
    fun reactiveLocation(): ReactiveLocationProvider = ReactiveLocationProvider(context)

    @Provides
    @ApplicationScope
    fun sharedPreferences(): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

    @Provides
    @ApplicationScope
    fun factory(builder: ViewModelsComponent.Builder): ViewModelProvider.Factory = MyViewModelFactory(builder.build())

}