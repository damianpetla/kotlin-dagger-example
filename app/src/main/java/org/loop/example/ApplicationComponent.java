package org.loop.example;

import javax.inject.Singleton;

import dagger.Component;

/**
 * This interface must be kept in java. Otherwise Dagger classes are not generated.
 */
@Singleton
@Component(modules = AndroidModule.class)
public interface ApplicationComponent {
    void inject(MyApplication application);

    void inject(MainActivity mainActivity);
}
