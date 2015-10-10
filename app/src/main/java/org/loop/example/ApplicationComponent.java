package org.loop.example;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by loop on 14/12/14.
 */
@Singleton
@Component(modules = AndroidModule.class)
public interface ApplicationComponent {
    void inject(MyApplication application);

    void inject(MainActivity mainActivity);
}
