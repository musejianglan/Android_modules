package com.promise.iocandroiddemo.ButterKnife;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by liulei on 2017/12/25.
 */

public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        initButterKnife();
    }

    private void initButterKnife() {
        ButterKnife.bind(this);
    }

    public abstract int getLayoutRes();
}
