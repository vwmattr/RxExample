package com.vwmattr.rxexample.components;

import com.vwmattr.rxexample.App;
import com.vwmattr.rxexample.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit.RestAdapter;

/**
 * Created by rein on 11/15/15.
 */
@Singleton
@Component(
        modules = {
                AppModule.class
        }
)

public interface AppComponent {
    void inject(App app);
    RestAdapter getRestAdapter();
}
