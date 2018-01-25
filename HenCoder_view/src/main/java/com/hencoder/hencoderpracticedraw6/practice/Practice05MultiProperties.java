package com.hencoder.hencoderpracticedraw6.practice;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.musejianglan.customview.R;


public class Practice05MultiProperties extends ConstraintLayout {
    Button animateBt;
    ImageView imageView;
    private int state = 0;

    public Practice05MultiProperties(Context context) {
        super(context);
    }

    public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setScaleX(0);
        imageView.setScaleY(0);
        imageView.setAlpha(0f);
        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 在这里处理点击事件，同时对多个属性做动画

                switch (state % 5) {
                    case 0:
                        imageView.animate().scaleX(1f).scaleY(1f).alpha(1).rotation(120).translationX(50).setDuration
                                (2000);
                        break;
                    case 1:
                        imageView.animate().translationX(200).translationY(200).setDuration(500);
                        break;
                    case 2:
                        imageView.animate().alpha(0.5f);
                        break;
                    case 3:
                        imageView.animate().scaleY(1.2f).scaleX(2.0f);
                        break;
                    case 4:
                        imageView.animate().rotation(0).alpha(1f).scaleX(1).scaleY(1);
                        break;

                }
                state ++;
            }
        });
    }
}
