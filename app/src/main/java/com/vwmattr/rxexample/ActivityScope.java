package com.vwmattr.rxexample;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Annotation for Dagger2 components that signifies the scope of the component is the Activity to
 * that the Component injects.
 * Created by rein on 11/16/15.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}
