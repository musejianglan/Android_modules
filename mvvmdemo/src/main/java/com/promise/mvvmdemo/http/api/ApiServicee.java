package com.promise.mvvmdemo.http.api;


import com.promise.mvvmdemo.bean.BaseResult;
import com.promise.mvvmdemo.bean.Meizi;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author: liulei
 * @date:2018/4/24
 */
public interface ApiServicee {

    String HOST = "http://gank.io/";
    String API_SERVER_URL = HOST + "api/data/";


    @GET("data/福利/30/1")
    Observable<BaseResult<List<Meizi>>> getMezi();

    @GET("data/福利/1/1")
    Observable<String> getMezi2();
}
