package com.promise.picapp;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by liulei on 2017/12/22.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);//fresco

        LeakCanary.install(this);//LeakCanary
        //refWatcher = installLeakCanary();
    }

    //private RefWatcher refWatcher;
    //
    //
    //
    //protected RefWatcher installLeakCanary() {
    //    return LeakCanary.install(this);
    //}
}
