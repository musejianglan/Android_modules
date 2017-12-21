package com.musejianglan.mvpdemo.services;

import com.musejianglan.mvpdemo.github.model.GithubUser;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by liulei on 2017/12/21.
 */

public interface GithubApi {

    @GET("users/{user}")
    Call<GithubUser> listRepos(@Path("user") String user);
}
