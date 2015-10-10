package org.loop.example

import android.location.LocationManager
import javax.inject.Inject


/**
 * Created by loop on 09/12/14.
 */

public class MyApplication : BaseApplication() {

    companion object {
        //platformStatic allow access it from java code
        @JvmStatic lateinit public var graph: ApplicationComponent
    }

    lateinit var locationManager: LocationManager
        @Inject set

    override fun onCreate() {
        super.onCreate()
        graph = createApplicationComponent()
        graph.inject(this)

        println("App: $locationManager")
        //TODO do some other cool stuff here
    }
}