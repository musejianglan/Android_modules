package com.musejianglan.rxjavademo.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.musejianglan.rxjavademo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThreadSchedulingFragment extends BaseFragment {
    @BindView(R.id.result)
    TextView textView;

    public ThreadSchedulingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_thread_scheduling, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.thread_schedul)
    public void threadSchedlue(){

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                Log.e(TAG, "Observable thread is : " + Thread.currentThread().getName());
                e.onNext(1);
                e.onComplete();
                setTextView("Observable thread is : " + Thread.currentThread().getName());
            }
        }).subscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer integer) throws Exception {
                        Log.e(TAG, "After observeOn(mainThread)，Current thread is " + Thread.currentThread().getName());
                        setTextView("After observeOn(mainThread)，Current thread is " + Thread.currentThread().getName());
                    }
                })
                .observeOn(Schedulers.io())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer integer) throws Exception {
                        Log.e(TAG, "After observeOn(io)，Current thread is " + Thread.currentThread().getName());
                        setTextView("After observeOn(io)，Current thread is " + Thread.currentThread().getName());
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
