package com.promise.mvvmdemo.model;

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
 * @date:2018/5/10
 */
public class MeizhiModel {

    public void getNewMeizhiData(final IResult<BaseResult<List<Meizi>>> iresult){

        iresult.onStart();
        ApiFactory.getApiService()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseResult<List<Meizi>>>() {
                    @Override
                    public void accept(BaseResult<List<Meizi>> listBaseResult) throws Exception {
                        iresult.onSuccess(listBaseResult);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iresult.onFail(throwable);
                    }
                });

    }
}
