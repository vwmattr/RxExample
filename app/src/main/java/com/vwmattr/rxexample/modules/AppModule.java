package com.vwmattr.rxexample.modules;

import android.app.Application;

import com.vwmattr.rxexample.App;
import com.vwmattr.rxexample.api.RestApiAdapter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

/**
 * Created by rein on 11/15/15.
 */
@Module
public class AppModule {

    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return app;
    }

    @Provides
    @Singleton
    public RestAdapter provideRestAdapter() {
        return RestApiAdapter.getInstance();
    }
}
