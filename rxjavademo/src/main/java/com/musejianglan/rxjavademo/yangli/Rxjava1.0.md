package com.musejianglan.rxjavademo.yangli;

import android.util.Log;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


/**
 * Created by liulei on 2017/12/18.
 */

public class Demo1 {


    private static final String TAG = "Rxjava";
    /**
     * Observer 观察者
     */
    Observer<String> observer = new Observer<String>() {


        @Override
        public void onNext(String s) {
            Log.d(TAG,"item" + s);
        }

        @Override
        public void onCompleted() {
            Log.d(TAG,"onComplete");
        }

        @Override
        public void onError(Throwable e) {
            Log.d(TAG,"onError");
        }


    };

    /**
     * Subscriber 是 Observer 的抽象类
     *
     *
     */

    Subscriber<String> subscriber = new Subscriber<String>() {




        @Override
        public void onNext(String s) {
            Log.d(TAG,"item" + s);
        }

        @Override
        public void onCompleted() {
            Log.d(TAG,"onComplete");
        }

        @Override
        public void onError(Throwable t) {
            subscriber.unsubscribe();
        }




    };

    /**
     * Observable 被观察者
     */

    Observable observable = Observable.create(new Observable.OnSubscribe<String>() {


        @Override
        public void call(Subscriber<? super String> subscriber) {
            subscriber.onNext("aaaaa");
            subscriber.onNext("bbb");
            subscriber.onNext("ccc");
            subscriber.onCompleted();
        }
    });


    /**
     * 订阅
     */
    {

        observable.subscribe(observer);
        observable.subscribe(subscriber);
    }

    Action1<String> onNextAction = new Action1<String>() {
        @Override
        public void call(String s) {
            Log.d(TAG,s);
        }
    };
    {
        observable.subscribe(onNextAction);
    }


    {

        String[] names = {"a","s","d","f"};

//        Observable.from(names)
//                .subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                System.out.println(s);
//            }
//        });


    }


    /**
     * Scheduler 调度器
     */
    public static void main(String[] args) {
        Schedulers.immediate();//直接运行在当前线程，相当于不指定线程。默认的Scheduler
        Schedulers.newThread();//总是弃用新线程，并在新线程执行操作
        Schedulers.io();//I/O操做所用的线程
        Schedulers.computation();//计算所使用的scheduler
        AndroidSchedulers.mainThread();//指定的操作将在Android主线程运行


//        Integer[] arg = {1,2,3,4,5,6};
//        Observable.just(arg)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<Integer>() {
//                    @Override
//                    public void call(Integer number) {
//                        Log.d(TAG, "number:" + number);
//                    }
//                });
    }









}
