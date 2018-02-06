package com.musejianglan.databindingdemo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.musejianglan.databindingdemo.bean.UserBean;
import com.musejianglan.databindingdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ActivityMainBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        UserBean userBean = new UserBean("暮色将蓝",20);
        viewDataBinding.setUser(userBean);
        viewDataBinding.setClicker(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_1:
                toast("绑定多种数据类型");
                startActivity(new Intent(MainActivity.this,DataTypeActivity.class));
                break;
            case R.id.btn_22:
                toast("来自按钮222");
                startActivity(new Intent(MainActivity.this,RecyclerActivity.class));
                break;
        }

    }

    public void toast(String msg){

        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

}
