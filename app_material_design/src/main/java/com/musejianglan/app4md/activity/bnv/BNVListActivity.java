package com.musejianglan.app4md.activity.bnv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.musejianglan.app4md.R;
import com.musejianglan.app4md.activity.BaseActivity;

public class BNVListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bnvlist);
    }

    public void styleAct(View view) {
        startActivity(StyleActivity.class);
    }

    public void withVp(View view) {
        startActivity(WithViewPagerActivity.class);
    }

    public void setupWithVP(View view) {
        startActivity(SetupWithViewPagerActivity.class);
    }

    public void badgeview(View view) {
        startActivity(BadgeViewActivity.class);
    }

    public void centerfab(View view) {
        startActivity(CenterFabActivity.class);
    }

    public void myBnvActivity(View view) {
        startActivity(MyBnvActivity.class);
    }
}
