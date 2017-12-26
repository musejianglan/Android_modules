package com.musejianglan.rxjavademo.http.interfaces;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;

/**
 * Created by liulei on 2017/12/19.
 */

public interface GankApi {


    @GET("data/福利/10/1")
    Observable<ResponseBody> gankFuli();


}
