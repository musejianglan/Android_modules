package com.promise.eventbusdemo.eventbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.promise.eventbusdemo.R;
import com.promise.eventbusdemo.eventbus.event.ToastEvent;

import org.greenrobot.eventbus.EventBus;

public class EventPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_post);
    }

    public void postMsg(View view) {

        EventBus.getDefault().post(new ToastEvent("这是发送的信息"));
    }

    public void postAsyc(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                EventBus.getDefault().post(new ToastEvent(Thread.currentThread().getName() + "这是在子线程发送的信息"));
            }
        }).start();
    }
}
