package com.musejianglan.app4md.activity;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

/**
 * @author: liulei
 * @date:2018/5/4
 */
public class BaseActivity extends AppCompatActivity {

    private static final String TAG = "Meterial_Design";

    public void toast(String msg){

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

        Log.e(TAG, "msg >>>>>> " + msg);

    }
}
