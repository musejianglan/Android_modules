package com.musejianglan.rxjavademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.musejianglan.rxjavademo.bean.Translation;
import com.musejianglan.rxjavademo.http.ApiFactory;
import com.musejianglan.rxjavademo.http.interfaces.FyApi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class Rxjava2Activity extends AppCompatActivity {

    public static final String TAG = "PROMISE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava2);


//        lunxun();//轮询
        
//        map_();

        flatmap_();

        concatmap_();

    }

    private void concatmap_() {


    }

    /**
     * 注：新合并生成的事件序列顺序是无序的，即 与旧序列发送事件的顺序无关
     */
    private void flatmap_() {

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onNext(4);
            }
        }).flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                final List<String> list = new ArrayList<>();
                for (int i = 5;i<10;i++) {
                    list.add("我是事件 " + integer + "拆分后的子事件" + i);
                }
                return Observable.fromIterable(list);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                log(s);
            }
        });


    }

    private void map_() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
            }
        }).map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                return "发送的integer类型数据，转换成String类型数据"+integer;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {

                log(s);

            }
        });
    }

    public void log(String msg) {
        Log.e(TAG,msg);
    }
    private void lunxun() {

        Observable.interval(2,1, TimeUnit.SECONDS)
                .doOnNext(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.e(TAG,"这是第几次轮训："+aLong);

                        FyApi fyApi = ApiFactory.getFyApi();
                        Observable<Translation> observable = fyApi.fanyi();

                        observable.subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Observer<Translation>() {
                                    @Override
                                    public void onSubscribe(Disposable d) {

                                    }

                                    @Override
                                    public void onNext(Translation translation) {
                                        translation.show();
                                        Log.e(TAG,Thread.currentThread().getName());

                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        Log.e(TAG,e.getMessage());
                                    }

                                    @Override
                                    public void onComplete() {

                                    }
                                });
                    }
                }).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long aLong) {
                Log.e(TAG, "对next事件作出响应"+aLong);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "对Error事件作出响应");
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "对Complete事件作出响应");
            }
        });
    }
}
