package org.loop.example

import android.location.LocationManager
import javax.inject.Inject


/**
 * Created by loop on 09/12/14.
 */

public class MyApplication : BaseApplication() {

    var locationManager: LocationManager? = null
        [Inject] set

    override fun onCreate() {
        super<BaseApplication>.onCreate()
        component.inject(this)

        println("App: $locationManager")
        //TODO do some other cool stuff here
    }
}