package com.promise.architecturecomponents.viewModel;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.promise.architecturecomponents.R;
import com.promise.architecturecomponents.viewModel.viewmodel.NameViewModel;

public class ViewModelActivity extends AppCompatActivity {

    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);

        text = findViewById(R.id.text);
        NameViewModel nameViewModel = ViewModelProviders.of(this).get(NameViewModel.class);

        nameViewModel.getNameMutableLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                text.setText(s);
            }
        });


    }

    public void name(View view) {

    }
}
