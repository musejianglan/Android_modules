package com.promise.mvvmdemo.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.promise.mvvmdemo.App;


/**
 * Created by liulei on 2017/12/15.
 */

public class HttpNetUtil {
    private static boolean isConnected = true;

    /**
     * 获取是否连接
     */
    public static boolean isConnected() {
        return isConnected;
    }

    private static void setConnected(boolean connected) {
        isConnected = connected;
    }

    /**
     * 判断网络连接是否存在
     */
    public static boolean setConnected() {
        ConnectivityManager manager =
                (ConnectivityManager) App.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager == null) {
            setConnected(false);
            return false;
        }

        NetworkInfo info = manager.getActiveNetworkInfo();

        boolean connected = info != null && info.isConnected();
        setConnected(connected);

        return connected;
    }
}
