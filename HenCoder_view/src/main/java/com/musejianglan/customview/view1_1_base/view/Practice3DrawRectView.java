package com.musejianglan.customview.view1_1_base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice3DrawRectView extends View {

    public Practice3DrawRectView(Context context) {
        super(context);
    }

    public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawRect() 方法画矩形
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        canvas.drawRect(50,50,150,100,paint);

        paint.setStyle(Paint.Style.STROKE);

        canvas.drawRect(200,50,300,150,paint);

        Rect rect = new Rect(50,170,250,250);
        canvas.drawRect(rect,paint);

        RectF rectF = new RectF(300f,170f,500f,250f);
        canvas.drawRect(rectF,paint);
        //rect 和 RectF的区别
        //int     float
    }
}
