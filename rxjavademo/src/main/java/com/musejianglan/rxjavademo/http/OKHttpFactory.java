package com.musejianglan.rxjavademo.http;


import android.util.Log;

import com.musejianglan.rxjavademo.App;
import com.musejianglan.rxjavademo.http.interceptor.OnOffLineCachedInterceptor;
import com.musejianglan.rxjavademo.http.interceptor.UserAgentInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by liulei on 2017/12/15.
 */

public class OKHttpFactory {
    private final OkHttpClient okHttpClient;

    private static final int TIMEOUT_READ = 25;
    private static final int TIMEOUT_CONNECTION = 25;

    private static final OKHttpFactory ourInstance = new OKHttpFactory();

    public static OKHttpFactory getInstance() {
        return ourInstance;
    }

    private OKHttpFactory() {
        //打印请求Log
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        Log.i("123","aaaa");

        //缓存目录
        Cache cache = new Cache(App.context.getCacheDir(), 10 * 1024 * 1024);

        okHttpClient = new OkHttpClient.Builder()
                //打印请求log
                .addInterceptor(interceptor)

                //stetho,可以在chrome中查看请求
//                .addNetworkInterceptor(new StethoInterceptor())

                //添加UA
                .addInterceptor(new UserAgentInterceptor("UA"))

                //必须是设置Cache目录
                .cache(cache)

                //走缓存，两个都要设置
                .addInterceptor(new OnOffLineCachedInterceptor())
                .addNetworkInterceptor(new OnOffLineCachedInterceptor())

                //失败重连
                .retryOnConnectionFailure(true)

                //time out
                .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)

                .build();
    }

    public OkHttpClient getOkHttpClient(){
        return okHttpClient;
    }
}
