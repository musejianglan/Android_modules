package com.musejianglan.customview.layout2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import static android.content.ContentValues.TAG;

/**
 * Created by liulei on 2018/1/25.
 */

public class LayoutMeasure2View extends View {
    public LayoutMeasure2View(Context context) {
        super(context);
    }

    public LayoutMeasure2View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LayoutMeasure2View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.YELLOW);

        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);

        int height = getHeight();
        int width = getWidth();

        Log.d(TAG,"ondraw:"+height+"---------"+width);
        int r = 200;

        canvas.drawCircle(width / 2,height/2,r,mPaint);

        mPaint.setTextSize(48);
        mPaint.setColor(Color.BLUE);

        String text = "musejianglan";
        float measureText = mPaint.measureText(text);
        canvas.drawText(text,width / 2 - measureText / 2, height / 2 + r + 40,mPaint);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);


        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        if (measuredHeight == 0) {
            measuredHeight = 400+ 40 + 100;
        }

        if (measuredWidth == 0) {
            measuredWidth = 400+getPaddingRight()+getPaddingLeft();
        }
        Log.d(TAG,measuredHeight+"*********"+measuredWidth);
        measuredWidth = resolveSize(measuredWidth, widthMeasureSpec);
        measuredHeight = resolveSize(measuredHeight, heightMeasureSpec);

        Log.d(TAG,measuredHeight+"--------"+measuredWidth);


        setMeasuredDimension(measuredWidth,measuredHeight);
    }




}
