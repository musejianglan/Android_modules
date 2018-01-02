package com.musejianglan.app4exit;

import android.os.Bundle;
import android.view.View;

public class Main4Activity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }

    public void nextPage(View view) {
        App app = (App) getApplication();
        app.exitApp();

    }

    public void bus(View view) {
        postExitApp();
    }
}
