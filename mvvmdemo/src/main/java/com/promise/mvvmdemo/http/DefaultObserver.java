package com.promise.mvvmdemo.http;

import android.app.Activity;
import android.net.ParseException;
import android.widget.Toast;

import com.google.gson.JsonParseException;
import com.promise.mvvmdemo.bean.BaseResult;
import com.promise.mvvmdemo.http.interfaces.IResult;
import com.promise.mvvmdemo.utils.CommonDialogUtils;
import com.promise.mvvmdemo.utils.LogUtils;
import com.promise.mvvmdemo.utils.ToastUtils;

import org.json.JSONException;

import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

import static com.promise.mvvmdemo.http.DefaultObserver.ExceptionReason.CONNECT_ERROR;
import static com.promise.mvvmdemo.http.DefaultObserver.ExceptionReason.CONNECT_TIMEOUT;
import static com.promise.mvvmdemo.http.DefaultObserver.ExceptionReason.PARSE_ERROR;
import static com.promise.mvvmdemo.http.DefaultObserver.ExceptionReason.UNKNOWN_ERROR;

/**
 * @author: liulei
 * @date:2018/4/24
 */
public abstract class DefaultObserver<T extends BaseResult> implements Observer<T> ,IResult<T>{
    private Activity activity;
    //  Activity 是否在执行onStop()时取消订阅
    private boolean isAddInStop = false;
    private CommonDialogUtils dialogUtils;
    public DefaultObserver(Activity activity) {
        this(activity,true);
    }

    public DefaultObserver(Activity activity, boolean isShowLoading) {
        this.activity = activity;
        dialogUtils=new CommonDialogUtils();
        if (isShowLoading) {
            dialogUtils.showProgress(activity,"Loading...");
        }
        onStart();
    }
    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull T t) {
        dismissProgress();
        if (!t.isError()) {
            // 拦截处理
            onSuccess(t);
        } else {
            onFail(new Throwable("error"));
        }
    }

    private void dismissProgress(){
        if(dialogUtils!=null){
            dialogUtils.dismissProgress();
        }
    }


    @Override
    public void onError(@NonNull Throwable e) {
        LogUtils.e(e.getMessage());
        dismissProgress();
        if (e instanceof HttpException) {     //   HTTP错误
            onException(ExceptionReason.BAD_NETWORK);
        } else if (e instanceof ConnectException
                || e instanceof UnknownHostException) {   //   连接错误
            onException(CONNECT_ERROR);
        } else if (e instanceof InterruptedIOException) {   //  连接超时
            onException(CONNECT_TIMEOUT);
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {   //  解析错误
            onException(PARSE_ERROR);
        } else {
            onException(UNKNOWN_ERROR);
        }
    }

    @Override
    public void onComplete() {
        if(dialogUtils!=null){
            dialogUtils.dismissProgress();
        }
    }


    /**
     * 请求异常
     *
     * @param reason
     */
    public void onException(ExceptionReason reason) {
        switch (reason) {
            case CONNECT_ERROR:
                ToastUtils.show("连接错误", Toast.LENGTH_SHORT);
                break;

            case CONNECT_TIMEOUT:
                ToastUtils.show("连接超时", Toast.LENGTH_SHORT);
                break;

            case BAD_NETWORK:
                ToastUtils.show("网络异常", Toast.LENGTH_SHORT);
                break;

            case PARSE_ERROR:
                ToastUtils.show("解析异常", Toast.LENGTH_SHORT);
                break;

            case UNKNOWN_ERROR:
            default:
                ToastUtils.show("未知错误", Toast.LENGTH_SHORT);
                break;
        }
    }

    /**
     * 请求网络失败原因
     */
    public enum ExceptionReason {
        /**
         * 解析数据失败
         */
        PARSE_ERROR,
        /**
         * 网络问题
         */
        BAD_NETWORK,
        /**
         * 连接错误
         */
        CONNECT_ERROR,
        /**
         * 连接超时
         */
        CONNECT_TIMEOUT,
        /**
         * 未知错误
         */
        UNKNOWN_ERROR,
    }
}
