package com.vwmattr.rxexample.components;

import com.vwmattr.rxexample.ActivityScope;
import com.vwmattr.rxexample.MainActivity;
import com.vwmattr.rxexample.modules.MainModule;

import dagger.Component;

/**
 * Created by rein on 11/16/15.
 */
@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = MainModule.class
)
public interface MainComponent {
    void inject(MainActivity activity);
}
