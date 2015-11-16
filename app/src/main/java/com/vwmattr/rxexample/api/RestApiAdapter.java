package com.vwmattr.rxexample.api;

import retrofit.RestAdapter;

/**
 * Created by rein on 11/16/15.
 */
public class RestApiAdapter {

    private static RestAdapter sharedInstance = null;

    public static RestAdapter getInstance() {
        if (sharedInstance == null){

            sharedInstance = new RestAdapter.Builder()
                    .setEndpoint("https://api.stackexchange.com")
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .build();
        }

        return sharedInstance;
    }
}
