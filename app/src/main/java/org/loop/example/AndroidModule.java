package org.loop.example;

import android.content.Context;
import android.location.LocationManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import se.omni.dagger.ForApplication;

/**
 * A module for Android-specific dependencies which require a {@link android.content.Context} or
 * {@link android.app.Application} to create.
 */
@Module
public class AndroidModule {
    private final BaseApplication application;

    public AndroidModule(BaseApplication application) {
        this.application = application;
    }

    /**
     * Allow the application context to be injected but require that it be annotated with
     * {@link ForApplication @Annotation} to explicitly differentiate it from an activity context.
     */
    @Provides
    @Singleton @ForApplication
    Context provideApplicationContext() {
        return application;
    }

    @Provides @Singleton
    LocationManager provideLocationManager() {
        return (LocationManager) application.getSystemService(Context.LOCATION_SERVICE);
    }
}
