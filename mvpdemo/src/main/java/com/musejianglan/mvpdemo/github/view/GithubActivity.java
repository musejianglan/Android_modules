package com.musejianglan.mvpdemo.github.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.musejianglan.mvpdemo.R;
import com.musejianglan.mvpdemo.github.model.GithubUser;
import com.musejianglan.mvpdemo.github.presenter.GithubPresenterImpl;
import com.musejianglan.mvpdemo.github.presenter.IGithubPresenter;

public class GithubActivity extends AppCompatActivity implements View.OnClickListener, IGithubView {

    private EditText github_username;
    private Button login_github;
    private Button clear_username;
    private TextView textView2;

    IGithubPresenter githubPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github);


        github_username = findViewById(R.id.editText);
        login_github = findViewById(R.id.login_github);
        clear_username = findViewById(R.id.clear_name);
        textView2 = findViewById(R.id.textView2);


        githubPresenter = new GithubPresenterImpl(this);

        login_github.setOnClickListener(this);
        clear_username.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.login_github:
                githubPresenter.login(github_username.getText().toString());
                break;
            case R.id.clear_name:
                githubPresenter.clear();
                break;
        }

    }

    @Override
    public void onClear() {
        github_username.setText("");
        textView2.setText("清空。。。。。。。。。。");
    }

    @Override
    public void onLoginSuccess(GithubUser user) {
        textView2.setText(user.toString());
    }

    @Override
    public void onLoginFail(String errorMsg) {
        textView2.setText(errorMsg);
    }
}
