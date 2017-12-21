package com.musejianglan.mvpdemo.login.presenter;

import android.os.Handler;
import android.os.Looper;

import com.musejianglan.mvpdemo.login.model.IUser;
import com.musejianglan.mvpdemo.login.model.UserModel;
import com.musejianglan.mvpdemo.login.view.ILoginView;



/**
 * Created by liulei on 2017/12/21.
 */

public class LoginPresenterCompl implements ILoginPresenter {

    ILoginView iLoginView;
    IUser user;
    Handler handler;

    public LoginPresenterCompl(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        initUser();
        handler = new Handler(Looper.getMainLooper());
    }

    private void initUser() {
        user = new UserModel("mvp","mvp");
    }

    @Override
    public void clear() {

        iLoginView.onClearText();

    }

    @Override
    public void doLogin(String name, String password) {

        boolean success = true;

        final int i = user.checkName(name, password);
        if (i!=0) success = false;
        final boolean result = success;

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iLoginView.onLoginResult(result,i);

            }
        },3000);

    }

    @Override
    public void setProgressBarVisiblity(int visiblity) {
        iLoginView.onSetProgressBarVisibility(visiblity);

    }
}
