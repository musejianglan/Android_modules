package com.musejianglan.rxjavademo.http.interfaces;

import com.musejianglan.rxjavademo.bean.Translation;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by liulei on 2017/12/20.
 */

public interface FyApi {

    @GET("ajax.php?a=fy&f=auto&t=auto&w=hi%20world")
    Observable<Translation> fanyi();
}
