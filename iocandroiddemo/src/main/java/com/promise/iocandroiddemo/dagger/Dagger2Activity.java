package com.promise.iocandroiddemo.dagger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.promise.iocandroiddemo.R;
import com.promise.iocandroiddemo.dagger.bean.Watch;
import com.promise.iocandroiddemo.dagger.component.Dagger2ActivityComponent;
import com.promise.iocandroiddemo.dagger.component.DaggerDagger2ActivityComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Dagger2Activity extends AppCompatActivity {

    @Inject
    Watch watch;

    @BindView(R.id.buttonsss)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger2);
        ButterKnife.bind(this);

//        Dagger2ActivityComponent.create().inject(this);
        DaggerDagger2ActivityComponent.create().inject(this);
    }

    @OnClick(R.id.buttonsss)
    public void btn(){
        watch.work();
    }
}
