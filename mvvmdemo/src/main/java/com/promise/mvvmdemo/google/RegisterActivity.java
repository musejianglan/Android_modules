package com.promise.mvvmdemo.google;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.promise.mvvmdemo.R;
import com.promise.mvvmdemo.databinding.ActivityRegisterBinding;
import com.promise.mvvmdemo.google.bean.RegisterBean;
import com.promise.mvvmdemo.google.viewmodel.RegistViewModel;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;
    RegistViewModel registViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_register);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);

        binding.setRegisterActivity(this);
        binding.setClickable(true);
        registViewModel = ViewModelProviders.of(this).get(RegistViewModel.class);
        getLifecycle().addObserver(registViewModel);
    }

    public void code(View view){


        String phone = binding.etPhone.getText().toString().trim();
        if (!TextUtils.isEmpty(phone) && TextUtils.isDigitsOnly(phone)) {
            binding.setClickable(false);
//            countDownTimer.start();

            registViewModel.getCode().observe(this, new Observer<Integer>() {
                @Override
                public void onChanged(@Nullable Integer integer) {
                    if (integer > 0) {
                        binding.btCode.setText(integer+"秒后重新获取");
                    }else {
                        binding.setClickable(true);
                        binding.btCode.setText("再次获取验证码");
                    }
                }
            });

        }else {
            Toast.makeText(getApplicationContext(), "请输入正确手机号", Toast.LENGTH_SHORT).show();
        }


    }

    public void regist(View v){
        registViewModel.regist("123").observe(this, new Observer<RegisterBean>() {
            @Override
            public void onChanged(@Nullable RegisterBean registerBean) {

                if (registerBean.isSuccess()) {
                    setResult(registerBean.getCode());
                    finish();

                }else {
                    Toast.makeText(getApplicationContext(), "重新注册", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

//    CountDownTimer countDownTimer = new CountDownTimer(1000*60,1000) {
//        @Override
//        public void onTick(long millisUntilFinished) {
//            binding.btCode.setText((millisUntilFinished / 1000)+"秒后重新获取");
//            Log.e("liu", "=====>>>>> "+millisUntilFinished);
//
//        }
//
//        @Override
//        public void onFinish() {
//            binding.setClickable(true);
//            binding.btCode.setText("再次获取验证码");
//        }
//    };

    @Override
    protected void onStop() {
        super.onStop();
//        countDownTimer.cancel();
    }
}
