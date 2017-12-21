package com.musejianglan.mvpdemo.login.view;

/**
 * Created by liulei on 2017/12/21.
 */

public interface ILoginView {

    public void onClearText();
    public void onLoginResult(boolean result,int code);
    public void onSetProgressBarVisibility(int visibility);
}
