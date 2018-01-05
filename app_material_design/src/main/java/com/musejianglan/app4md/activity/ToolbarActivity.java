package com.musejianglan.app4md.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.musejianglan.app4md.R;

public class ToolbarActivity extends AppCompatActivity {

    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        mToolbar = findViewById(R.id.toolbar2);
        //默认toolbar显示项目名称

        setSupportActionBar(mToolbar);
    }
}
