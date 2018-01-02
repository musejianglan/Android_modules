package com.musejianglan.app4exit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void nextPage(View view) {
        startActivity(new Intent(Main2Activity.this,Main3Activity.class));
    }
}
