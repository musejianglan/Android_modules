package com.musejianglan.rxjavademo.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.musejianglan.rxjavademo.R;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class RxBaseFragment extends BaseFragment {


    @BindView(R.id.result)
    TextView textView;

    public RxBaseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rx_base, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.interval)
    public void interval(){

//        Observable.interval(0, 1000, TimeUnit.MILLISECONDS)
//                .subscribe(new Consumer<Long>() {
//                    @Override
//                    public void accept(Long aLong) throws Exception {
//                        setTextView("interval >>>> "+aLong);
//                    }
//                });
        Observable.interval(0,1, TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
                    Disposable disposable;
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onNext(Long aLong) {
                        setTextView("interval <<<>>> "+aLong);
                        if (aLong == 10) {
                            disposable.dispose();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        setTextView("interval >>>> 异常");
                    }

                    @Override
                    public void onComplete() {
                        setTextView("interval >>>> 完成");
                    }
                });

    }

    @OnClick(R.id.just_Consumer)
    public void just_Consumer(){
        setTextView(null);
        setTextView("Consumer是简易版的Observer，他有多重重载，可以自定义你需要处理的信息，我这里调用的是只接受onNext消息的方法， 他只提供一个回调接口accept，由于没有onError和onCompete，无法再 接受到onError或者onCompete之后，实现函数回调。无法回调，并不代表不接收，他还是会接收到onCompete和onError之后做出默认操作，也就是监听者（Consumer）不在接收Observable发送的消息");

        Observable.just(1,2,3,4,5,6,7,8,9)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        setTextView("just >>>> "+integer);
                    }
                });

    }

    @OnClick(R.id.button3)
    public void click(){

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                Log.e(TAG, "Observable emit 1" + "\n");
                e.onNext(1);
                Log.e(TAG, "Observable emit 2" + "\n");
                e.onNext(2);
                Log.e(TAG, "Observable emit 3" + "\n");
                e.onNext(3);
                e.onComplete();
                Log.e(TAG, "Observable emit 4" + "\n" );
                e.onNext(4);
            }
        }).subscribe(new Observer<Integer>() {
            // 第二步：初始化Observer
            private int i;
            private Disposable mDisposable;
            @Override
            public void onSubscribe(Disposable d) {
                mDisposable = d;

            }

            @Override
            public void onNext(Integer s) {
                Log.d(TAG, "observer"+s);
                i++;
//                if (i == 2) {
//                    // 在RxJava 2.x 中，新增的Disposable可以做到切断的操作，让Observer观察者不再接收上游事件
//                    mDisposable.dispose();
//                }

            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError : value : " + e.getMessage() + "\n" );
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete" + "\n" );
//                textView.setText("rxjava请求完成" + System.currentTimeMillis());
                setTextView("rxjava基本用法完成" + System.currentTimeMillis());
            }
        });

    }

    public void setTextView(final @Nullable String str){

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.isEmpty(str)) {
                    textView.setText("");

                }else {
                    textView.setText(textView.getText()+"\n"+str);
                }
            }
        });


    }

    @Override
    protected void initViewsAndEvents() {
        Log.e(TAG, this.getClass().getSimpleName() + ">>>>>>>>>>>initViewsAndEvents");
    }

    @Override
    protected void onFirstUserVisible() {
        Log.e(TAG, this.getClass().getSimpleName() + ">>>>>>>>>>>onFirstUserVisible");
    }

    @Override
    protected void onUserVisible() {
        Log.e(TAG, this.getClass().getSimpleName() + ">>>>>>>>>>>onUserVisible");
    }

    @Override
    protected void onFirstUserInvisible() {
        Log.e(TAG, this.getClass().getSimpleName() + ">>>>>>>>>>>onFirstUserInvisible");
    }

    @Override
    protected void onUserInvisible() {
        Log.e(TAG, this.getClass().getSimpleName() + ">>>>>>>>>>>onUserInvisible");
    }
}
