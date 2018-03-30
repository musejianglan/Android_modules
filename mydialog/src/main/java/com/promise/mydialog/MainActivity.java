package com.promise.mydialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.dialog_fragment})
    public void dialogFragment(){

        new SysDialogFragment()
                .show(getSupportFragmentManager(), MainActivity.class.getSimpleName());

    }

    @OnClick({R.id.dialog_fragment3})
    public void dialogFragment3(){

        new CustomSysDialogFragment()
                .show(getSupportFragmentManager(), MainActivity.class.getSimpleName());

    }

    @OnClick({R.id.dialog_fragment2})
    public void dialogFragment2(){

        new MyDialogFragment()
                .show(getSupportFragmentManager(), MainActivity.class.getSimpleName());

    }
}
