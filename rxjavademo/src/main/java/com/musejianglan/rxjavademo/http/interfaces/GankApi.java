package com.musejianglan.rxjavademo.http.interfaces;

import com.musejianglan.rxjavademo.bean.GankFuliBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by liulei on 2017/12/19.
 */

public interface GankApi {


    @GET("data/福利/10/1")
    Observable<ResponseBody> gankFuli();


    @GET("data/福利/{per}/{num}")
    Call<GankFuliBean> gank4retrofit(@Path("per") int per,@Path("num") int num);


}
