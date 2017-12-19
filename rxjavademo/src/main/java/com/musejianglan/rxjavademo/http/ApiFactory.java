package com.musejianglan.rxjavademo.http;

import com.musejianglan.rxjavademo.http.interfaces.GankApi;

/**
 * Created by liulei on 2017/12/15.
 */

public class ApiFactory {


    private static GankApi gankApi;

    public static GankApi gitHubAPI() {
        if (gankApi == null) {
            gankApi = RetrofitClient.getInstance().getRetrofit().create(GankApi.class);
        }

        return gankApi;
    }
}
