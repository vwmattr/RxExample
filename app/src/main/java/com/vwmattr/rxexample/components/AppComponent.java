package com.vwmattr.rxexample.components;

import com.vwmattr.rxexample.App;
import com.vwmattr.rxexample.Server;
import com.vwmattr.rxexample.modules.ApiModule;
import com.vwmattr.rxexample.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by rein on 11/15/15.
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                ApiModule.class
        }
)

public interface AppComponent {
    void inject(App app);
    Server getApiServer();
}
