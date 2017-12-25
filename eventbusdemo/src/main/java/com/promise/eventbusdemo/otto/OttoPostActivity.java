package com.promise.eventbusdemo.otto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.promise.eventbusdemo.R;
import com.promise.eventbusdemo.otto.event.OttoMsgEvent;

public class OttoPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otto_post);
    }

    public void postNormal(View view) {

        OttoBus.getInstance().post(new OttoMsgEvent("发送otto消息"));
    }

    public void postAsyc(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OttoBus.getInstance().post(new OttoMsgEvent("来自子线程-----发送otto消息"));
            }
        }).start();
    }
}
