package com.promise.mvvmdemo;

import android.app.Application;
import android.content.Context;

/**
 * @author: liulei
 * @date:2018/4/24
 */
public class App extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = this;
    }
}
