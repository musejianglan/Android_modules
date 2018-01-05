package com.musejianglan.app4md.activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.musejianglan.app4md.R;

public class CoordinatorLayoutActivity extends AppCompatActivity {

    private Button mButton;
    private ImageView mImageView;
    private ImageView mImageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout);

        mButton = findViewById(R.id.button);
        mImageView = findViewById(R.id.imageview);
        mImageView2 = findViewById(R.id.imageview2);

        mButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        v.setX(event.getRawX() - v.getWidth() / 2);
                        v.setY(event.getRawY() - v.getHeight() / 2);
                        break;
                }
                return false;
            }
        });

        ImageBehavior fancyBehavior = new ImageBehavior(this,null);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) mImageView2.getLayoutParams();
        params.setBehavior(fancyBehavior);





    }


}
