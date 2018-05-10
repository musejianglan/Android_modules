package com.promise.mvvmdemo.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.promise.mvvmdemo.R;
import com.promise.mvvmdemo.bean.BaseResult;
import com.promise.mvvmdemo.bean.Meizi;
import com.promise.mvvmdemo.databinding.ActivityMainBinding;
import com.promise.mvvmdemo.http.api.ApiFactory;
import com.promise.mvvmdemo.http.interfaces.IResult;
import com.promise.mvvmdemo.model.MeizhiModel;
import com.promise.mvvmdemo.view.adapter.MeizhiAdapter;
import com.promise.mvvmdemo.viewmodel.MeiziViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initView();
    }

    private void initView() {

        binding.recycleview.setLayoutManager(new LinearLayoutManager(this));
        MeizhiAdapter meizhiAdapter = new MeizhiAdapter(MainActivity.this);
        binding.recycleview.setAdapter( meizhiAdapter);

        new MeiziViewModel(MainActivity.this,meizhiAdapter).getData();





    }


}
