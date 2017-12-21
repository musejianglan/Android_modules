package com.musejianglan.mvpdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.musejianglan.mvpdemo.github.view.GithubActivity;
import com.musejianglan.mvpdemo.login.view.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view) {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }

    public void githubClick(View view) {
        startActivity(new Intent(MainActivity.this, GithubActivity.class));
    }
}
