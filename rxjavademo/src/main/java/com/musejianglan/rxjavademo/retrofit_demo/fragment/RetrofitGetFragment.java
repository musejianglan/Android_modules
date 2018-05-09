package com.musejianglan.rxjavademo.retrofit_demo.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.musejianglan.rxjavademo.R;
import com.musejianglan.rxjavademo.bean.GankFuliBean;
import com.musejianglan.rxjavademo.http.ApiFactory;
import com.musejianglan.rxjavademo.retrofit_demo.Constans;

import org.w3c.dom.Text;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class RetrofitGetFragment extends Fragment {

    @BindView(R.id.textview)
    TextView textView;

    public RetrofitGetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_retrofit_only, container, false);
        ButterKnife.bind(this, view);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @OnClick(R.id.getPath)
    public void click(){

//        ApiFactory.gitHubAPI().gank4retrofit(20, 1).enqueue(new Callback<GankFuliBean>() {
//            @Override
//            public void onResponse(Call<GankFuliBean> call, Response<GankFuliBean> response) {
//                textView.setText(response.body().toString());
//            }
//
//            @Override
//            public void onFailure(Call<GankFuliBean> call, Throwable t) {
//                textView.setText(t.getMessage());
//            }
//        });

        ApiFactory.getXbkpApi()
                .getCenter(Constans.token)
                .enqueue(new Callback<ResponseBody>() {
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
                        textView.setText(t.getMessage());
                    }
                });

    }

    @OnClick(R.id.getQuery)
    public void getQuery(){
        ApiFactory.getXbkpApi()
                .getVersion("ANDROID")
                .enqueue(new Callback<ResponseBody>() {
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
                        textView.setText(t.getMessage());
                    }
                });
    }
}
