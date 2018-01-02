package com.musejianglan.app4exit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main3Activity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void nextPage(View view) {
        startActivity(new Intent(Main3Activity.this,Main4Activity.class));
    }
}
