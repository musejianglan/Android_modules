package com.promise.espressotests;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText editText;
    private EditText editText2;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);

        textView = findViewById(R.id.textView);
    }

    public void sum(View view) {

        String num1 = editText.getText().toString().trim();
        String num2 = editText2.getText().toString().trim();

        textView.setText("计算结果："+(Integer.parseInt(num1) + Integer.parseInt(num2)));
    }

    public void web(View view) {
        startActivity(new Intent(MainActivity.this,WebActivity.class));
    }

    public void list(View view) {
        startActivity(new Intent(MainActivity.this,WebActivity.class));
    }
}
