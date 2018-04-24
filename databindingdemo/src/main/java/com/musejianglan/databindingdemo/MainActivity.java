package com.musejianglan.databindingdemo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.musejianglan.databindingdemo.bean.UserBean;
import com.musejianglan.databindingdemo.databinding.ActivityMainBinding;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    UserBean userBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ActivityMainBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        userBean = new UserBean("暮色将蓝",20);
        viewDataBinding.setUser(userBean);
        viewDataBinding.setClicker(this);

        viewDataBinding.setVariable(BR.user, userBean);

        viewDataBinding.setImgUrl("http://7xi8d6.com1.z0.glb.clouddn.com/20180129074038_O3ydq4_Screenshot.jpeg");

        viewDataBinding.btn1.setText("绑定多种数据类型");

        viewDataBinding.textAge.setText("更改age:"+2222);
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
            case R.id.beanNotify:
                userBean.setAge((int) new Date().getTime());
                userBean.setName(new Date().getTime()+"=====>>>>");
                break;

            case R.id.event_deal:
                startActivity(new Intent(MainActivity.this,EventDealActivity.class));
                break;
        }

    }

    public void toast(String msg){

        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

}
