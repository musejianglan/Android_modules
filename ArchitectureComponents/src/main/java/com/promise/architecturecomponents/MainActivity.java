package com.promise.architecturecomponents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.promise.architecturecomponents.lifecycle.LifecycleActivity;
import com.promise.architecturecomponents.liveData.LiveDataActivity;
import com.promise.architecturecomponents.room.RoomActivity;
import com.promise.architecturecomponents.viewModel.ViewModelActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lifecycle(View view) {

        startActivity(LifecycleActivity.class);
    }

    public void liveData(View view) {
        startActivity(LiveDataActivity.class);
    }

    public void viewModel(View view) {
        startActivity(ViewModelActivity.class);
    }

    public void room(View view) {
        startActivity(RoomActivity.class);
    }

    public void startActivity(Class clazz){

        startActivity(new Intent(MainActivity.this,clazz));

    }
}
