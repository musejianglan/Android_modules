package com.promise.eventbusdemo.otto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.promise.eventbusdemo.R;
import com.promise.eventbusdemo.otto.event.OttoMsgEvent;
import com.squareup.otto.Produce;

public class ProduceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produce);

        OttoBus.getInstance().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        OttoBus.getInstance().unregister(this);
    }

    @Produce
    public OttoMsgEvent sendProduceMsg() {
        return new OttoMsgEvent("来自otto produce 的消息");

    }

    public void produce_msg(View view) {
        finish();
    }
}
