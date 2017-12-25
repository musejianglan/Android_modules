package com.promise.eventbusdemo.otto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.promise.eventbusdemo.R;
import com.promise.eventbusdemo.otto.event.OttoMsgEvent;
import com.squareup.otto.Subscribe;

public class OttoReceiverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otto_receiver);

        log("注册otto");
        OttoBus.getInstance().register(this);
    }

    public void log(String msg){
        Log.e("otto",OttoReceiverActivity.class.getSimpleName() + "-----"+Thread.currentThread().getName() + "----" + msg);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        log("注销otto");
        OttoBus.getInstance().unregister(this);

    }

    @Subscribe
    public void receriverMsg(OttoMsgEvent ottoMsgEvent){
        log(ottoMsgEvent.getMsg());

    }

    public void nextPage(View view) {

        startActivity(new Intent(OttoReceiverActivity.this,OttoPostActivity.class));
    }

    public void produce(View view) {
        startActivity(new Intent(OttoReceiverActivity.this,ProduceActivity.class));

    }

    public void firstPage(View view) {
        startActivity(new Intent(OttoReceiverActivity.this,FirstPageActivity.class));
    }
}
