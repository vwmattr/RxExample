package com.vwmattr.rxexample.modules;

import com.vwmattr.rxexample.Server;

import dagger.Module;
import dagger.Provides;
import retrofit.Retrofit;

/**
 * Created by rein on 11/16/15.
 */
@Module
public class ApiModule {

    @Provides
    public Server provideServer(Retrofit retrofit) {
        return retrofit.create(Server.class);
    }
}
