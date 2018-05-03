package com.musejianglan.rxjavademo.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.musejianglan.rxjavademo.R;
import com.musejianglan.rxjavademo.bean.GankFuliBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChainingOperatorsMapFragment extends BaseFragment {

    @BindView(R.id.result)
    TextView textView;

    public ChainingOperatorsMapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chaining_operators_map, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @SuppressLint("CheckResult")
    @OnClick(R.id.map1)
    public void map1(){
        Observable.create(new ObservableOnSubscribe<Response>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Response> e) throws Exception {
                Request.Builder builder = new Request.Builder()
                        .url("http://gank.io/api/data/福利/1/1")
                        .get();
                Request request = builder.build();
                Call call = new OkHttpClient().newCall(request);
                Response response = call.execute();
                e.onNext(response);
                setTextView("发起请求");
            }
        }).map(new Function<Response, GankFuliBean>() {
            @Override
            public GankFuliBean apply(@NonNull Response response) throws Exception {
                if (response.isSuccessful()) {
                    ResponseBody body = response.body();
                    if (body != null) {
                        Log.e(TAG, "map:转换前:" + body);
                        setTextView("map:转换前:" + body);
                        return new Gson().fromJson(body.string(), GankFuliBean.class);
                    }
                }
                return null;
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<GankFuliBean>() {
                    @Override
                    public void accept(@NonNull GankFuliBean s) throws Exception {
                        Log.e(TAG, "doOnNext: 保存成功：" + s.toString() + "\n");
                        setTextView("doOnNext: 保存成功：" + s.toString());
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GankFuliBean>() {
                    @Override
                    public void accept(@NonNull GankFuliBean data) throws Exception {
                        Log.e(TAG, "成功:" + data.toString() + "\n");
                        setTextView("成功:" + data.toString());
                    }}, new Consumer<Throwable>() {
                            @Override
                            public void accept(@NonNull Throwable throwable) throws Exception {
                                Log.e(TAG, "失败：" + throwable.getMessage() + "\n");
                                setTextView("失败：" + throwable.getMessage());
                            }
                        }

                );


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
