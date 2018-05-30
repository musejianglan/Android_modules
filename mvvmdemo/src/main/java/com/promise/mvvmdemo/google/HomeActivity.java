package com.promise.mvvmdemo.google;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

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
//        user.setName(binding.etName.getText().toString());
//        user.setPassword(binding.etPassword.getText().toString());
//        binding.setUser(user);
        homeViewModel.getGank(binding.etName.getText().toString(),binding.etPassword.getText().toString()).observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                if (s == null) {
                    user.setName("登录失败");
                    user.setPassword(s);
                }else {
                    user.setName("登录成功");
                    user.setPassword(s);
                }
                binding.setUser(user);
            }
        });

    }

    public void onRegister(View v){

        startActivityForResult(new Intent(HomeActivity.this,RegisterActivity.class),100);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == 200) {
            Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_SHORT).show();
            User user = new User();
            user.setName("注册成功");
            user.setPassword("ssss");
            binding.setUser(user);
        }
    }
}
