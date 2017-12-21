package com.musejianglan.mvpdemo.github.presenter;

import android.text.TextUtils;

import com.musejianglan.mvpdemo.github.model.GithubUser;
import com.musejianglan.mvpdemo.github.view.IGithubView;
import com.musejianglan.mvpdemo.services.GithubApi;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by liulei on 2017/12/21.
 */

public class GithubPresenterImpl implements IGithubPresenter {

    private IGithubView githubView;

    public GithubPresenterImpl(IGithubView githubView) {
        this.githubView = githubView;
        githubView.onLoginFail("初始化中。。。。。。。。。。。。。。");
    }

    @Override
    public void clear() {
        githubView.onClear();

    }

    @Override
    public void login(String username) {
        if (TextUtils.isEmpty(username)) githubView.onLoginFail("用户名不能为空");
        githubView.onLoginFail("请求数据中");
        Retrofit build = new Retrofit.Builder().baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final GithubApi githubApi = build.create(GithubApi.class);
        Call<GithubUser> githubUserCall = githubApi.listRepos(username);
        githubUserCall.enqueue(new Callback<GithubUser>() {
            @Override
            public void onResponse(Call<GithubUser> call, Response<GithubUser> response) {
                if (response.isSuccessful())
                    githubView.onLoginSuccess(response.body());
                else
                    try {
                        githubView.onLoginFail(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }

            @Override
            public void onFailure(Call<GithubUser> call, Throwable t) {

                githubView.onLoginFail(t.getMessage());
            }
        });
    }
}
