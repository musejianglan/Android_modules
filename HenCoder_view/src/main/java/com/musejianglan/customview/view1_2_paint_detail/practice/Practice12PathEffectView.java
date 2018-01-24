package com.musejianglan.customview.view1_2_paint_detail.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.SumPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice12PathEffectView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();

    public Practice12PathEffectView(Context context) {
        super(context);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setStyle(Paint.Style.STROKE);

        path.moveTo(50, 100);
        path.rLineTo(50, 100);
        path.rLineTo(80, -150);
        path.rLineTo(100, 100);
        path.rLineTo(70, -120);
        path.rLineTo(150, 80);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.setPathEffect() 来设置不同的 PathEffect

        // 第一处：CornerPathEffect
        PathEffect pathEffect1 = new CornerPathEffect(50);//变圆角 圆角半径
        paint.setPathEffect(pathEffect1);
        canvas.drawPath(path, paint);

        canvas.save();
        canvas.translate(500, 0);
        // 第二处：DiscretePathEffect
        //segmentLength 是用来拼接的每个线段的长度， deviation 是偏离量。
        PathEffect pathEffect2 = new DiscretePathEffect(50,10);//使线变得乱七八糟
        paint.setPathEffect(pathEffect2);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 200);
        // 第三处：DashPathEffect
        float[] intervals = {30,20,100,5};//必须是偶数，按照线长，空白，线长，空白长排列
        PathEffect pathEffect3 = new DashPathEffect(intervals,4);//第二个参数偏移量
        paint.setPathEffect(pathEffect3);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 200);
        // 第四处：PathDashPathEffect
        Path dashPath = new Path();
        dashPath.lineTo(20, -30);
        dashPath.lineTo(40, 0);
        dashPath.close();

        /**
         * advance 是两个相邻的 shape 段之间的间隔，
         * 不过注意，这个间隔是两个 shape 段的起点的间隔，而不是前一个的终点和后一个的起点的距离；
         * phase 和 DashPathEffect 中一样，是虚线的偏移；
         * 最后一个参数 style，是用来指定拐弯改变的时候 shape 的转换方式。
         * style 的类型为  PathDashPathEffect.Style ，
         * 是一个 enum ，具体有三个值：

         TRANSLATE：位移
         ROTATE：旋转
         MORPH：变体
         */
        PathEffect pathEffect4 = new PathDashPathEffect(dashPath,50,10, PathDashPathEffect.Style.MORPH);
        paint.setPathEffect(pathEffect4);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 400);
        // 第五处：SumPathEffect

        PathEffect dashEffect = new DashPathEffect(new float[]{100, 50}, 0);
        PathEffect discreteEffect = new DiscretePathEffect(20, 30);
        PathEffect pathEffect5 = new SumPathEffect(dashEffect, discreteEffect);
        paint.setPathEffect(pathEffect5);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 400);
        // 第六处：ComposePathEffect

        PathEffect dashEffect2 = new DashPathEffect(new float[]{100, 50}, 0);
        PathEffect discreteEffect2 = new DiscretePathEffect(20, 30);
        PathEffect pathEffect6 = new ComposePathEffect(dashEffect2, discreteEffect2);
        paint.setPathEffect(pathEffect6);
        canvas.drawPath(path, paint);
        canvas.restore();
    }
}
