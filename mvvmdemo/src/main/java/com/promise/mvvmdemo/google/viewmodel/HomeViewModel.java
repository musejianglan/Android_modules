package com.promise.mvvmdemo.google.viewmodel;


import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.text.TextUtils;

import com.promise.mvvmdemo.google.model.HomeRepository;
import com.promise.mvvmdemo.http.interfaces.IResult;

/**
 * @author: liulei
 * @date:2018/5/29
 */
public class HomeViewModel extends ViewModel {

    String name;
    String password;

    MutableLiveData<String> user;

    public void init(){
//        this.name = name;
//        this.password = password;
        user = new MutableLiveData<>();

    }



    public MutableLiveData<String> getGank(String name, String password){

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)) {
            return user;
        }

        HomeRepository.getGank(new IResult<String>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onFail(Throwable e) {

            }

            @Override
            public void onSuccess(String response) {
                user.setValue(response);
            }
        });

        return user;

    }


}
