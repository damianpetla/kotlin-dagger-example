package org.loop.example

import android.location.LocationManager
import javax.inject.Inject
import kotlin.platform.platformStatic
import kotlin.properties.Delegates


/**
 * Created by loop on 09/12/14.
 */

public class MyApplication : BaseApplication() {

    companion object {
        //platformStatic allow access it from java code
        platformStatic public var graph: ApplicationComponent by Delegates.notNull()
    }

    var locationManager: LocationManager? = null
        [Inject] set

    override fun onCreate() {
        super<BaseApplication>.onCreate()
        graph = createApplicationComponent()
        graph.inject(this)

        println("App: $locationManager")
        //TODO do some other cool stuff here
    }
}