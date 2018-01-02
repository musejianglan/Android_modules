package com.musejianglan.app4exit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by liulei on 2018/1/2.
 */

public class BaseActivity extends AppCompatActivity {
    public final static String FLAG_EXIT_APP = "exit";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!EventBus.getDefault().isRegistered(this)) {
            Log.e(FLAG_EXIT_APP,this.getLocalClassName());
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            Log.e(FLAG_EXIT_APP,this.getLocalClassName()+"---ondestroy");
            EventBus.getDefault().unregister(this);
        }
    }

    @Subscribe
    public void exitApp(ExitEvent event){

        Log.d(FLAG_EXIT_APP,event.toString());

        this.finish();

    }

    public void postExitApp(){
        EventBus.getDefault().post(new ExitEvent());
        System.exit(0);
    }


}
