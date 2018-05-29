package com.promise.mvvmdemo.google;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.promise.mvvmdemo.R;
import com.promise.mvvmdemo.databinding.ActivityHomeBinding;
import com.promise.mvvmdemo.google.bean.User;
import com.promise.mvvmdemo.google.viewmodel.HomeViewModel;

public class HomeActivity extends AppCompatActivity {


    ActivityHomeBinding binding;
    HomeViewModel homeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        binding.setHomeActivity(this);

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        homeViewModel.init();
    }

    public void onClick(View view){

//        homeViewModel.

        final User user = new User();
        user.setName(binding.etName.getText().toString());
        user.setPassword(binding.etPassword.getText().toString());
        binding.setUser(user);
        homeViewModel.getGank().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                user.setName(s);
            }
        });

    }
}
