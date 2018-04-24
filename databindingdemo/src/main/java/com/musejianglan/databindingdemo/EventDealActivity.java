package com.musejianglan.databindingdemo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.musejianglan.databindingdemo.databinding.ActivityEventDealBinding;
import com.musejianglan.databindingdemo.databinding.ActivityMainBinding;
import com.musejianglan.databindingdemo.eventdeal.MyHandler;

public class EventDealActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_event_deal);

        ActivityEventDealBinding eventDealBinding = DataBindingUtil.setContentView(this, R.layout.activity_event_deal);
        eventDealBinding.setMyHandler(new MyHandler());
    }
}
