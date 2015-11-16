package com.vwmattr.rxexample.modules;

import com.vwmattr.rxexample.Server;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

/**
 * Created by rein on 11/16/15.
 */
@Module
public class MainModule {

    @Provides
    public Server provideServer(RestAdapter restAdapter) {
        return restAdapter.create(Server.class);
    }
}
