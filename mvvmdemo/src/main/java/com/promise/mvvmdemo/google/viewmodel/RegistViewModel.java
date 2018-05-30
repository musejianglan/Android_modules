package com.promise.mvvmdemo.google.viewmodel;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ViewModel;
import android.os.CountDownTimer;
import android.util.Log;

import com.promise.mvvmdemo.google.bean.RegisterBean;
import com.promise.mvvmdemo.google.model.HomeRepository;
import com.promise.mvvmdemo.http.interfaces.IResult;
import com.promise.mvvmdemo.utils.LogUtils;

/**
 * @author: liulei
 * @date:2018/5/29
 */
public class RegistViewModel extends ViewModel implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    protected void onStop(LifecycleOwner owner) {
        LogUtils.e(this.getClass().getSimpleName() + " >> onStop");
        countDownTimer.cancel();
    }


    MutableLiveData<RegisterBean> register = new MutableLiveData<RegisterBean>();
    public MutableLiveData<Integer> code = new MutableLiveData<Integer>();


    public void getCode() {
        countDownTimer.start();
        //网络请求
    }


    CountDownTimer countDownTimer = new CountDownTimer(1000*60,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            Log.e("liu", "=====>>>>> "+millisUntilFinished);

            code.setValue((int) (millisUntilFinished / 1000));
        }

        @Override
        public void onFinish() {
        }
    };

    public MutableLiveData<RegisterBean> regist(String phone){
        final RegisterBean registerBean = new RegisterBean();

        HomeRepository.getGank(new IResult<String>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onFail(Throwable e) {
                registerBean.setCode(201);
                registerBean.setSuccess(false);
                register.setValue(registerBean);

            }

            @Override
            public void onSuccess(String response) {
                registerBean.setCode(200);
                registerBean.setSuccess(true);
                register.setValue(registerBean);

            }
        });

        return register;

    }
}
