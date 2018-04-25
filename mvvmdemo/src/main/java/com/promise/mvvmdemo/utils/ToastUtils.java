package com.promise.mvvmdemo.utils;

import android.widget.Toast;

import com.promise.mvvmdemo.App;

/**
 * @author: liulei
 * @date:2018/4/24
 */
public class ToastUtils {
    public static void show(String message) {
        show(message, Toast.LENGTH_SHORT);
    }

    public static void show(String message,int duration) {
        Toast.makeText(App.context, message, duration).show();
    }
}
