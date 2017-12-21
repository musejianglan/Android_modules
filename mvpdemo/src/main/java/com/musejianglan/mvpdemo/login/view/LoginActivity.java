package com.musejianglan.mvpdemo.login.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.musejianglan.mvpdemo.R;
import com.musejianglan.mvpdemo.login.presenter.ILoginPresenter;
import com.musejianglan.mvpdemo.login.presenter.LoginPresenterCompl;

public class LoginActivity extends AppCompatActivity implements ILoginView,View.OnClickListener {


    private EditText username;
    private EditText password;
    private Button login;
    private Button clear;
    ILoginPresenter loginPresenter;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {
        username = this.findViewById(R.id.username);
        password = this.findViewById(R.id.password);
        login = this.findViewById(R.id.login);
        clear = this.findViewById(R.id.clear);
        textView = this.findViewById(R.id.textView);

        login.setOnClickListener(this);
        clear.setOnClickListener(this);

        loginPresenter = new LoginPresenterCompl(this);
        loginPresenter.setProgressBarVisiblity(View.GONE);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.login:
                loginPresenter.setProgressBarVisiblity(View.VISIBLE);
                login.setEnabled(false);
                clear.setEnabled(false);
                loginPresenter.doLogin(username.getText().toString(),password.getText().toString());
                break;
            case R.id.clear:
                loginPresenter.clear();
                break;
        }

    }

    @Override
    public void onClearText() {

        username.setText("");
        password.setText("");

    }

    @Override
    public void onLoginResult(boolean result, int code) {

        loginPresenter.setProgressBarVisiblity(View.INVISIBLE);
        login.setEnabled(true);
        clear.setEnabled(true);

        if (result) {
            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(LoginActivity.this,"登录失败：" + code,Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {

        textView.setText(visibility+"");
    }
}
