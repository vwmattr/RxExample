package com.vwmattr.rxexample.modules;

import android.app.Application;

import com.vwmattr.rxexample.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

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
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://api.stackexchange.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        //TODO: If I want logging, I'll have to add an interceptor to this.  See: https://github.com/square/okhttp/wiki/Interceptors
//        .setLogLevel(RestAdapter.LogLevel.FULL)
    }
}
