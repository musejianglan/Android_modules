package com.promise.picapp.webp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.promise.picapp.R;

public class WebpActivity extends AppCompatActivity {

    private ImageView webp2;
    private ImageView webp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webp);

        webp1 = findViewById(R.id.webp1);
        webp2 = findViewById(R.id.webp2);

        webp1.setImageResource(R.drawable.home);

        Glide.with(this).load(R.drawable.home).into(webp2);
    }
}
