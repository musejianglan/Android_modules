package com.musejianglan.rxjavademo;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.musejianglan.rxjavademo.retrofit_demo.RetrofitActivity;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.functions.Consumer;


public class MainActivity extends AppCompatActivity {

    RxPermissions rxPermissions;

    static final String[] PERMISSIONS = new String[]{
            Manifest.permission.WRITE_CALENDAR,
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_CONTACTS,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.BODY_SENSORS,
            Manifest.permission.RECEIVE_SMS,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestPermissions();
    }

    private void requestPermissions() {
        rxPermissions = new RxPermissions(this); // where this is an Activity instance
        rxPermissions.setLogging(true);
    }

    public void rxPermissions_request(View view) {
        rxPermissions.request(PERMISSIONS)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean) {
                            //所有权限都开启aBoolean才为true，否则为false
                            toast(null,"权限已开启");
                        } else {
                            toast(null,"权限被拒绝，请在设置里面开启相应权限，若无相应权限会影响使用");
                        }
                    }
                });
    }
    private void toast(Permission permission, String msg) {
        if (permission != null) {
            Log.e("123", permission.name +" ===>> " + permission.granted);
        }
        Toast.makeText(this, (permission!=null?permission.name:"") + msg, Toast.LENGTH_SHORT).show();

    }

    public void rxPermissions_requestEach(View view) {
        rxPermissions.requestEach(PERMISSIONS)
                .subscribe(new Consumer<Permission>() {
                    @Override
                    public void accept(Permission permission) throws Exception {
                        if (permission.granted) {
                            // 用户已经同意该权限

                            toast(permission,"用户已经同意该权限");
                        } else if (permission.shouldShowRequestPermissionRationale) {
                            // 用户拒绝了该权限，没有选中『不再询问』（Never ask again）,那么下次再次启动时，还会提示请求权限的对话框
                            toast(permission,"用户拒绝了该权限");
                        } else {
                            // 用户拒绝了该权限，并且选中『不再询问』，提醒用户手动打开权限
                            toast(permission,"权限被拒绝，请在设置里面开启相应权限，若无相应权限会影响使用");
                        }
                    }
                });
    }

    public void rx1click(View view) {

        startActivity(new Intent(MainActivity.this,Rxjava2Activity.class));

    }

    public void onGson(View view) {

        startActivity(new Intent(MainActivity.this,GsonActivity.class));
    }

    public void rx2click(View view) {
        startActivity(new Intent(MainActivity.this,HomeActivity.class));
    }

    public void retrofit(View view) {
        startActivity(new Intent(MainActivity.this,RetrofitActivity.class));
    }


}
