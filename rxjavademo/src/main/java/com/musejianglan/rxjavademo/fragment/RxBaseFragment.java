package com.musejianglan.rxjavademo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.musejianglan.rxjavademo.R;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

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

    @OnClick(R.id.just_Consumer)
    public void just_Consumer(){

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

    public void setTextView(final String str){

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView.setText(textView.getText()+"\n"+str);
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
