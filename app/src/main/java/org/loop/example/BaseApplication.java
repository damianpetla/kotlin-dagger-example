package org.loop.example;

import android.app.Application;

/**
 * Created by loop on 09/12/14.
 */
public abstract class BaseApplication extends Application {

    protected ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * This initialization cannot be moved to Kotlin.
         * Compiler will fail with Unresolved reference error: Dagger_ApplicationComponent
         */
        component = Dagger_ApplicationComponent.builder()
                .androidModule(new AndroidModule(this)).build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
