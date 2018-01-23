package com.musejianglan.customview.view1_1_base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice6DrawLineView extends View {

    public Practice6DrawLineView(Context context) {
        super(context);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawLine() 方法画直线

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        canvas.drawLine(50f,50f,300f,50f,paint);

        float[] pts = {50,100,350,100,
                        200,100,200,500,
                        50,500,350,500};
        canvas.drawLines(pts,paint);
    }
}
