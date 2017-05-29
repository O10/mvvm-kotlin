package com.kissdigital.mvvm_kotlin.app

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.support.v4.util.ArrayMap
import com.kissdigital.mvvm_kotlin.app.di.components.ViewModelsComponent
import com.kissdigital.mvvm_kotlin.ui.clicks.ClicksViewModel
import com.kissdigital.mvvm_kotlin.ui.main.MainViewModel
import timber.log.Timber
import java.util.concurrent.Callable

/**
 * Created by O10 on 29.05.2017.
 */
class MyViewModelFactory(viewModelsComponent: ViewModelsComponent) : ViewModelProvider.Factory {

    private val creators = ArrayMap<Class<*>, Callable<out ViewModel>>()

    init {
        creators.put(MainViewModel::class.java, Callable { viewModelsComponent.mainViewModel() })
        creators.put(ClicksViewModel::class.java, Callable { viewModelsComponent.clicksViewModel() })
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>?): T {
        var creator: Callable<out ViewModel>? = creators[modelClass]
        if (creator == null) {
            for ((key, value) in creators) {
                if (modelClass != null && modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }
        if (creator == null) {
            throw IllegalArgumentException("unknown model class " + modelClass)
        }
        try {
            Timber.d("Creating new view model of class %s", modelClass?.getSimpleName())
            return creator.call() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }
}