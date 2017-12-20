package com.musejianglan.rxjavademo.http;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by liulei on 2017/12/15.
 */

public class RetrofitClient {

    private static RetrofitClient retrofitClient = new RetrofitClient();
//    private static final String GITHUB_BASEURL = "http://gank.io/api/";//http://gank.io/api/
    private static final String GITHUB_BASEURL = "http://fy.iciba.com/";//http://fy.iciba.com/

    public static RetrofitClient getInstance() {
        return retrofitClient;
    }

    private final Retrofit retrofit;

    private RetrofitClient(){

        retrofit = new Retrofit.Builder()
                //设置OKHttpClient
                .client(OKHttpFactory.getInstance().getOkHttpClient())

                //baseUrl
                .baseUrl(GITHUB_BASEURL)

                //gson转化器
                .addConverterFactory(GsonConverterFactory.create(new Gson()))

                //Rx
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

                //创建
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }


}
