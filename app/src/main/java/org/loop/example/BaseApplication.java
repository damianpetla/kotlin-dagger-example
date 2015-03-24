package org.loop.example;

import android.app.Application;

/**
 * Created by loop on 09/12/14.
 */
public abstract class BaseApplication extends Application {

    protected ApplicationComponent createApplicationComponent() {
        return Dagger_ApplicationComponent.builder()
                .androidModule(new AndroidModule(this)).build();
    }

}
