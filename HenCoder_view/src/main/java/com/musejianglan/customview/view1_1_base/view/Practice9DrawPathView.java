package com.musejianglan.customview.view1_1_base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Path path = new Path();

        //path.addArc(200, 200, 400, 400, -225, 225);
        //path.arcTo(400, 200, 600, 400, -180, 225, false);
        //path.lineTo(400, 542);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            path.addArc(50,50,150,150,-225,225);
            path.arcTo(150,50,250,150,-180,225,false);
            //path.moveTo(250,100);
            path.lineTo(150,225);
            //path.lineTo(50,100);
            path.close();

            canvas.drawPath(path,paint);

        }
    }
}
