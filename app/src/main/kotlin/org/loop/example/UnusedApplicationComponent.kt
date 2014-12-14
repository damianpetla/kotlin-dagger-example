package org.loop.example

import dagger.Component
import javax.inject.Singleton

/**
 * Created by loop on 14/12/14.
 *
 * This trait is unused but it's kept to show that Kotlin trait is not generated for Dagger 2.
 */
//TODO remove this class
Singleton
Component(modules = array(javaClass<AndroidModule>()))
public trait UnusedApplicationComponent {
    public fun inject(application: MyApplication)

    public fun inject(mainActivity: MainActivity)
}