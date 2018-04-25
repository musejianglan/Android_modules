package com.promise.mvvmdemo.http;

import android.util.Log;

import com.promise.mvvmdemo.App;
import com.promise.mvvmdemo.http.interceptor.OnOffLineCachedInterceptor;
import com.promise.mvvmdemo.http.interceptor.UserAgentInterceptor;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author: liulei
 * @date:2018/4/24
 */
public class OkHttpUtil {


    private final OkHttpClient okHttpClient;

    private static final String TAG = "okhttp";
    private static final int TIMEOUT_READ = 25;
    private static final int TIMEOUT_CONNECTION = 25;

    private static final OkHttpUtil ourInstance = new OkHttpUtil();

    public static OkHttpUtil getInstance() {
        return ourInstance;
    }

    private OkHttpUtil() {
        //打印请求Log
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                try {
                    String text = URLDecoder.decode(message, "utf-8");
                    Log.e(TAG,text);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    Log.e(TAG,message);
                }
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

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
