package com.musejianglan.rxjavademo.http;

import com.musejianglan.rxjavademo.http.interfaces.FyApi;
import com.musejianglan.rxjavademo.http.interfaces.GankApi;

/**
 * Created by liulei on 2017/12/15.
 */

public class ApiFactory {



    public static GankApi gitHubAPI() {
        return RetrofitManager.getInstance().getRetrofit().create(GankApi.class);
    }

    public static FyApi getFyApi(){
        return RetrofitManager.getInstance().getRetrofit().create(FyApi.class);
    }
}
