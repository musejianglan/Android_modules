package com.musejianglan.app4md.activity.tab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.musejianglan.app4md.R;
import com.musejianglan.app4md.activity.BaseActivity;

public class TabListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_list);

    }

    public void fixedTab(View view) {
//        startActivity(new Intent(TabListActivity.this,FixedTabActivity.class));
        startActivity(FixedTabActivity.class);
    }

    public void scrollTab(View view) {
        startActivity(ScrollTabActivity.class);
    }

	public void tabWithIcon(View view) {
        startActivity(TabWithIconActivity.class);
	}

    public void tabTopWithViewPager(View view) {
        startActivity(TabVpActivity.class);
    }

    public void tabBottomWithViewPager(View view) {
        startActivity(TabBottomVpActivity.class);
    }
}
