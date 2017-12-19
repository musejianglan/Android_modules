package com.musejianglan.rxjavademo;

import android.app.Application;
import android.content.Context;

/**
 * Created by liulei on 2017/12/15.
 */

public class App extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = this;
    }


}
