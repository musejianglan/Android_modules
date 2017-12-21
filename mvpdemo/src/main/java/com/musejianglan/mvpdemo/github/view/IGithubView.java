package com.musejianglan.mvpdemo.github.view;

import com.musejianglan.mvpdemo.github.model.GithubUser;

/**
 * Created by liulei on 2017/12/21.
 */

public interface IGithubView {

    void onClear();
    void onLoginSuccess(GithubUser user);
    void onLoginFail(String errorMsg);
}
