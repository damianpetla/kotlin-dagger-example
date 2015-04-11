package org.loop.example;

import android.app.Application;

/**
 * Created by loop on 09/12/14.
 */
public abstract class BaseApplication extends Application {

    protected ApplicationComponent createApplicationComponent() {
        return DaggerApplicationComponent.builder()
                .androidModule(new AndroidModule(this)).build();
    }

}
