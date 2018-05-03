package com.musejianglan.rxjavademo.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
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
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChainingOperatorsFilterFragment extends BaseFragment {

    @BindView(R.id.result)
    TextView textView;

    public ChainingOperatorsFilterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chaining_operators_filter, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @SuppressLint("CheckResult")
    @OnClick(R.id.filter)
    public void filter(){

        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer % 2 == 0;
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.e(TAG, ">>>>>>>>>>>>>>" + integer);
                setTextView(integer+"-------");
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
