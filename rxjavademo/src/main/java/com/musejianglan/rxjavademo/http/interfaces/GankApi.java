package com.musejianglan.rxjavademo.http.interfaces;

import com.musejianglan.rxjavademo.bean.GankFuliBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by liulei on 2017/12/19.
 */

public interface GankApi {


    @GET("data/福利/10/1")
    Observable<GankFuliBean> gankFuli();


}
