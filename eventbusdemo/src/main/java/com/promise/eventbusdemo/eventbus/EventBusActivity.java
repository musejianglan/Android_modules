package com.promise.eventbusdemo.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.promise.eventbusdemo.R;
import com.promise.eventbusdemo.eventbus.event.ToastEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventBusActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);

        mTextView = findViewById(R.id.textView);

    }

    @Override
    protected void onResume() {
        super.onResume();


        if (!EventBus.getDefault().isRegistered(this)) {
            log("注册eventbus、");
            EventBus.getDefault().register(this);//注册eventbus、
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (EventBus.getDefault().isRegistered(this)) {
            log("注销eventbus");
            EventBus.getDefault().unregister(this);//注销eventbus
        }

    }


    public void startToPost(View view) {

        startActivity(new Intent(EventBusActivity.this,EventPostActivity.class));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void oneventReceiver(ToastEvent toastEvent) {
        //mTextView.setText("ThreadMode.MAIN"+toastEvent.getMsg());
        toast("ThreadMode.MAIN"+toastEvent.getMsg());
        log("ThreadMode.MAIN"+toastEvent.getMsg());

    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void oneventReceiver2(ToastEvent toastEvent) {
        //mTextView.setText("ThreadMode.ASYNC"+toastEvent.getMsg());
        toast("ThreadMode.ASYNC"+toastEvent.getMsg());
        log("ThreadMode.ASYNC"+toastEvent.getMsg());

    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void oneventReceiver3(ToastEvent toastEvent) {
        //mTextView.setText("ThreadMode.BACKGROUND"+toastEvent.getMsg());
        toast("ThreadMode.BACKGROUND"+toastEvent.getMsg());
        log("ThreadMode.BACKGROUND"+toastEvent.getMsg());

    }

    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED)
    public void oneventReceiver4(ToastEvent toastEvent) {
        //mTextView.setText("ThreadMode.MAIN_ORDERED"+toastEvent.getMsg());
        toast("ThreadMode.MAIN_ORDERED"+toastEvent.getMsg());
        log("ThreadMode.MAIN_ORDERED"+toastEvent.getMsg());

    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void oneventReceiver5(ToastEvent toastEvent) {
        //mTextView.setText("ThreadMode.POSTING"+toastEvent.getMsg());
        toast("ThreadMode.POSTING"+toastEvent.getMsg());
        log("ThreadMode.POSTING"+toastEvent.getMsg());

    }




    public void toast(String msg) {
        //Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
        //mTextView.setText(msg);

    }

    public void log(String msg){
        Log.e("evnetbus",Thread.currentThread().getName() + "------" +  msg);
    }
}
