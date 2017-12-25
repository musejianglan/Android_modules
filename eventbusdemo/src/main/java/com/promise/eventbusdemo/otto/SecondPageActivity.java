package com.promise.eventbusdemo.otto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.promise.eventbusdemo.R;
import com.promise.eventbusdemo.otto.event.OttoMsgEvent;

public class SecondPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        OttoBus.getInstance().post(new OttoMsgEvent("测试多个接受者"));
    }
}
