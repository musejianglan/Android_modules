package com.musejianglan.mvpdemo.login.presenter;

/**
 * Created by liulei on 2017/12/21.
 */

public interface ILoginPresenter {

    void clear();
    void doLogin(String name,String password);
    void setProgressBarVisiblity(int visiblity);
}
