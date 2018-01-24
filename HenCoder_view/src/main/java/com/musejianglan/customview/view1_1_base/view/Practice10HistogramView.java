package com.musejianglan.customview.view1_1_base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int interval = 40;
        int width = 90;
        int textSize = 26;

        String[] names = {"Froyo","GB","ICS","JB","KitKat","L","M"};

        Integer[] datas = {12,22,24,65,79,94,52};


//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        //canvas.drawColor(Color.parseColor("#44333333"));

        paint.setColor(Color.WHITE);
        float[] lines = {50,650,50,50,50,650,1050,650};
        canvas.drawLines(lines,paint);

        for (int i = 1;i <= names.length;i++) {
            String name = names[i -1];
            int data = datas[i - 1];

            paint.setColor(Color.GREEN);


            float left = 50 + interval * i + width * (i - 1);
            float top = 650f - 600f * data / 100;
            float right = left + width;
            float bottom = 650;
            canvas.drawRect(left,top,right,bottom,paint);

            paint.setColor(Color.WHITE);
            paint.setTextSize(textSize);
            float x = left + width / 2 - paint.measureText(name) / 2;
            float y = bottom + 20;
            canvas.drawText(name,x,y,paint);
            //Path path = new Path();
            //path.
            //canvas.drawTextOnPath(name,path,0,0,paint);
        }




    }
}
