package com.musejianglan.app4md.activity.tab;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.musejianglan.app4md.R;
import com.musejianglan.app4md.activity.BaseActivity;

public class FixedTabActivity extends BaseActivity {

    private TabLayout fixed_tablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixed_tab);

        fixed_tablayout = findViewById(R.id.fixed_tablayout);

        fixed_tablayout.addTab(fixed_tablayout.newTab().setText("本地"));
        fixed_tablayout.addTab(fixed_tablayout.newTab().setText("国内"));
        fixed_tablayout.addTab(fixed_tablayout.newTab().setText("国际"));

        fixed_tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                String text = tab.getText().toString();

                toast("onTabSelected:"+text);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                String text = tab.getText().toString();
                toast("onTabUnselected:"+text);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                String text = tab.getText().toString();
                toast("onTabReselected:"+text);
            }
        });
    }


}
