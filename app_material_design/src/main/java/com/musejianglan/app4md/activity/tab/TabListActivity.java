package com.musejianglan.app4md.activity.tab;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.musejianglan.app4md.R;

public class TabListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_list);

    }

    public void fixedTab(View view) {
        startActivity(new Intent(TabListActivity.this,FixedTabActivity.class));
    }
}
