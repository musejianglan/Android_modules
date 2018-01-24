package com.musejianglan.customview.view1_2_paint_detail.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.musejianglan.customview.R;


public class Practice06LightingColorFilterView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;

    public Practice06LightingColorFilterView(Context context) {
        super(context);
    }

    public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.setColorFilter() 来设置 LightingColorFilter


        //LightingColorFilter(int mul, int add)
        //R' = R * mul.R / 0xff + add.R
        //G' = G * mul.G / 0xff + add.G
        //B' = B * mul.B / 0xff + add.B

        /**
         * 第一个参数是除去哪个颜色，即设为00
         * 第二个参数增强哪个颜色
         */


        ColorFilter colorFilter1 = new LightingColorFilter(0x00ffff,0x000000);

        paint.setColorFilter(colorFilter1);
        // 第一个 LightingColorFilter：去掉红色部分
        canvas.drawBitmap(bitmap, 0, 0, paint);

        ColorFilter colorFilter2 = new LightingColorFilter(0xffffff,0x003000);

        paint.setColorFilter(colorFilter2);
        // 第二个 LightingColorFilter：增强绿色部分
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 100, 0, paint);
    }
}
