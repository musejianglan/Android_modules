package com.promise.picapp;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by liulei on 2017/12/22.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
