package com.promise.mvvmdemo.http.api;

import com.promise.mvvmdemo.bean.BaseResult;
import com.promise.mvvmdemo.bean.Meizi;
import com.promise.mvvmdemo.http.RetrofitClient;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by liulei on 2017/12/15.
 */

public class ApiFactory<T> {

    public static Observable<BaseResult<List<Meizi>>> getApiService() {

        return RetrofitClient.getInstance().getRetrofit().create(ApiServicee.class).getMezi();
    }

}
