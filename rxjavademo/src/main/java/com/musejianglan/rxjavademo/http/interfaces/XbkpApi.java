package com.musejianglan.rxjavademo.http.interfaces;

import com.musejianglan.rxjavademo.bean.Resetpwd;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author: liulei
 * @date:2018/5/9
 */
public interface XbkpApi {

    //GET /v1/app/getVersion
    @GET("/v1/app/getVersion")
    Call<ResponseBody> getVersion(@Query("platform") String platform);


    //GET /v1/user/center/{token}
    @GET("/v1/user/center/{token}")
    Call<ResponseBody> getCenter(@Path("token") String token);

    //POST /v1/user/resetpwd 使用 @Body 注解，指定一个对象作为 request body
    @POST("/v1/user/resetpwd")
    Call<ResponseBody> resetpwd(@Body Resetpwd resetpwd);
}
