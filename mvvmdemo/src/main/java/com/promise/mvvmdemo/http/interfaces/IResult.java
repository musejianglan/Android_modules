package com.promise.mvvmdemo.http.interfaces;

import io.reactivex.annotations.NonNull;

/**
 * @author: liulei
 * @date:2018/4/24
 */
public interface IResult<T> {

    void onStart();

    void onFail(@NonNull Throwable e);

    void onSuccess(T response);


}
