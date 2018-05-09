package com.musejianglan.rxjavademo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.musejianglan.rxjavademo.retrofit_demo.RetrofitActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void rx1click(View view) {

        startActivity(new Intent(MainActivity.this,Rxjava2Activity.class));

    }

    public void onGson(View view) {

        startActivity(new Intent(MainActivity.this,GsonActivity.class));
    }

    public void rx2click(View view) {
        startActivity(new Intent(MainActivity.this,HomeActivity.class));
    }

    public void retrofit(View view) {
        startActivity(new Intent(MainActivity.this,RetrofitActivity.class));
    }
}
