package com.promise.iocandroiddemo.dagger.bean;

import android.util.Log;

import javax.inject.Inject;

/**
 * @author: liulei
 * @date:2018/4/17
 */
public class Watch {

    @Inject
    public Watch() {
    }

    public void work(){
        Log.e(this.getClass().getSimpleName(), "dagger2 watch is work");
    }
}
