package com.promise.architecturecomponents.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.promise.architecturecomponents.R;

public class DefaultObserverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_observer);
    }
}
