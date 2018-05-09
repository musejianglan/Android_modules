package com.musejianglan.rxjavademo.retrofit_demo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.musejianglan.rxjavademo.R;
import com.musejianglan.rxjavademo.bean.Resetpwd;
import com.musejianglan.rxjavademo.bean.Translation1;
import com.musejianglan.rxjavademo.http.ApiFactory;
import com.musejianglan.rxjavademo.http.interfaces.FyApi;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class RetrofitPostFragment extends Fragment {

    @BindView(R.id.post_text)
    TextView textView;

    public RetrofitPostFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_retrofit_post, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.post_body)
    public void post_body(){
        Resetpwd resetpwd = new Resetpwd();
        resetpwd.setMobile("17777777777");
        resetpwd.setPassword("a1234567");
        ApiFactory.getXbkpApi().resetpwd(resetpwd).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    textView.setText(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }
    @OnClick(R.id.post_field)
    public void post_field(){


        new Retrofit.Builder().baseUrl("http://fanyi.youdao.com/")
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .build()
                .create(FyApi.class)
                .getCall("i love you")
                .enqueue(new Callback<Translation1>() {
                    @Override
                    public void onResponse(Call<Translation1> call, Response<Translation1> response) {
                        textView.setText(response.body().getTranslateResult().get(0).get(0).getTgt());
                    }

                    @Override
                    public void onFailure(Call<Translation1> call, Throwable t) {

                    }
                });

    }
    @OnClick(R.id.post_FieldMap)
    public void post_FieldMap(){


        Map<String, String> map = new HashMap<>();
        map.put("i", "i love you");
        new Retrofit.Builder().baseUrl("http://fanyi.youdao.com/")
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .build()
                .create(FyApi.class)
                .getFieldMap(map)
                .enqueue(new Callback<Translation1>() {
                    @Override
                    public void onResponse(Call<Translation1> call, Response<Translation1> response) {
                        textView.setText(response.body().getTranslateResult().get(0).get(0).getTgt());
                    }

                    @Override
                    public void onFailure(Call<Translation1> call, Throwable t) {

                    }
                });

    }

}
