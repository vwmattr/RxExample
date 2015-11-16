package com.vwmattr.rxexample;

import android.app.Application;
import android.content.Context;

import com.vwmattr.rxexample.components.AppComponent;
import com.vwmattr.rxexample.components.DaggerAppComponent;
import com.vwmattr.rxexample.modules.AppModule;

/**
 * Created by rein on 11/15/15.
 */
public class App extends Application {
    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        setupGraph();
    }

    private void setupGraph() {
        if (component == null) {
            component = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .build();
            component.inject(this);
        }
    }

    /**
     * Set a component that provides mock versions of dependencies in tests.
     * @param component
     */
    public void setComponent(AppComponent component) {
        this.component = component;
    }

    public AppComponent component() {
        return component;
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }
}
