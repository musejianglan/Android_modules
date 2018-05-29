package com.promise.mvvmdemo.google.model;

import com.promise.mvvmdemo.bean.BaseResult;
import com.promise.mvvmdemo.bean.Meizi;
import com.promise.mvvmdemo.http.api.ApiFactory;
import com.promise.mvvmdemo.http.interfaces.IResult;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author: liulei
 * @date:2018/5/29
 */
public class HomeRepository {

    public static void getGank(final IResult<String> result){
        ApiFactory.getApiService().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseResult<List<Meizi>>>() {
                    @Override
                    public void accept(BaseResult<List<Meizi>> listBaseResult) throws Exception {
                        result.onSuccess(listBaseResult.getResults().get(0).getUrl());
                    }
                });

    }
}
