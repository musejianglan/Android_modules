package com.musejianglan.customview.view1_1_base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice4DrawPointView extends View {

    public Practice4DrawPointView(Context context) {
        super(context);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPoint() 方法画点
//        一个圆点，一个方点
//        圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        paint.setStrokeWidth(50);
        canvas.drawPoint(50,50,paint);//默认方点

        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(150,50,paint);

        paint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawPoint(250,50,paint);
        
        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(350,50,paint);

        paint.setStrokeCap(Paint.Cap.ROUND);
        float[] pts = {50,150,150,150,250,150,350,150};
        canvas.drawPoints(pts,paint);


        paint.setStrokeWidth(20);
        float[] pts1 = {50,250,100,250,150,300,200,350,200,400,200,450,250,450,300,450,300,400,300,450,350,400};
        canvas.drawPoints(pts1,2,6,paint);//跳过两个数，绘制6个数，即跳过1个点，绘制3个点


    }
}
