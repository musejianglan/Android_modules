package com.musejianglan.customview.view1_1_base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice11PieChartView extends View {

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        //String[] names = {"Froyo","GB","ICS","JB","KitKat","L","M"};

        //Integer[] datas = {120,50,10,15,15,50,100};


//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        //paint.setColor(Color.RED);

        //canvas.drawOval(300,100,800,600,paint);

        float start = -180f;
        float sweep = 120f;
        paint.setColor(Color.parseColor("#80d8ff"));
        canvas.drawArc(280,80,780,580,start,sweep,true,paint);



        start += sweep;
        sweep = 50f;
        paint.setColor(Color.parseColor("#f44336"));
        canvas.drawArc(300,100,800,600,start,sweep,true,paint);




        start += sweep;
        sweep = 10f;
        paint.setColor(Color.parseColor("#76ff03"));
        canvas.drawArc(300,100,800,600,start,sweep,true,paint);



        start += sweep;
        sweep = 15f;
        paint.setColor(Color.parseColor("#ffd600"));
        canvas.drawArc(300,100,800,600,start,sweep,true,paint);


        //float alpha = start + sweep / 2;
        //float x = (float) (550 + Math.cos(alpha)*250);
        //float y = (float) (350 + Math.sin(alpha)*250);
        //paint.setColor(Color.RED);
        //canvas.drawLine(x,y,0,0,paint);


        start += sweep;
        sweep = 15f;
        paint.setColor(Color.parseColor("#ea80fc"));
        canvas.drawArc(300,100,800,600,start,sweep,true,paint);



        start += sweep;
        sweep = 50f;
        paint.setColor(Color.parseColor("#4db6ac"));
        canvas.drawArc(300,100,800,600,start,sweep,true,paint);



        start += sweep;
        sweep = 100f;
        paint.setColor(Color.parseColor("#ff6f00"));
        canvas.drawArc(300,100,800,600,start,sweep,true,paint);






    }
}
