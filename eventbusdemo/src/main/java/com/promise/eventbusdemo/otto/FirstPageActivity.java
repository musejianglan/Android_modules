package com.promise.eventbusdemo.otto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.promise.eventbusdemo.R;
import com.promise.eventbusdemo.otto.event.OttoMsgEvent;
import com.squareup.otto.Subscribe;

public class FirstPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        OttoBus.getInstance().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        OttoBus.getInstance().unregister(this);
    }

    @Subscribe
    public void receiverMsgFirstPage(OttoMsgEvent ottoMsgEvent){
        log(ottoMsgEvent.getMsg());
    }

    public void log(String msg){
        Log.e("otto",FirstPageActivity.class.getSimpleName() + "-----"+Thread.currentThread().getName() + "----" +
                msg);
    }

    public void secondPage(View view) {

        startActivity(new Intent(FirstPageActivity.this,SecondPageActivity.class));

    }
}
