package com.kissdigital.mvvm_kotlin.ui.main

import android.annotation.SuppressLint
import android.location.Location
import com.google.android.gms.location.LocationRequest
import com.jakewharton.rxrelay2.BehaviorRelay
import com.kissdigital.mvvm_kotlin.base.viewmodel.BaseViewModel
import hu.akarnokd.rxjava.interop.RxJavaInterop
import io.reactivex.Observable
import pl.charmas.android.reactivelocation.ReactiveLocationProvider
import javax.inject.Inject

/**
 * Created by O10 on 29.05.2017.
 */
class MainViewModel @Inject constructor(private val reactiveLocationProvider: ReactiveLocationProvider) : BaseViewModel() {

    private val currentLocation: BehaviorRelay<Location> = BehaviorRelay.create()

    @SuppressLint("MissingPermission")
    fun locationObservable(): Observable<Location> {
        val locationRequest = LocationRequest.create().setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY).setInterval(0)
        val source = RxJavaInterop.toV2Observable(reactiveLocationProvider
                .getUpdatedLocation(locationRequest))
                .subscribe(currentLocation)
        return currentLocation.doOnDispose { source.dispose() }
    }

}