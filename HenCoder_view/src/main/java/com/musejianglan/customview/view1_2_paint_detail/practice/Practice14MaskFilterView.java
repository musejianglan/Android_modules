package com.musejianglan.customview.view1_2_paint_detail.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.EmbossMaskFilter;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.musejianglan.customview.R;


public class Practice14MaskFilterView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;

    public Practice14MaskFilterView(Context context) {
        super(context);
    }

    public Practice14MaskFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice14MaskFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.what_the_fuck);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 用 Paint.setMaskFilter 来设置不同的 BlurMaskFilter

        // 第一个：NORMAL
        MaskFilter normal = new BlurMaskFilter(100, BlurMaskFilter.Blur.NORMAL);
        paint.setMaskFilter(normal);
        canvas.drawBitmap(bitmap, 100, 50, paint);

        // 第二个：INNER
        MaskFilter inner = new BlurMaskFilter(100, BlurMaskFilter.Blur.INNER);
        paint.setMaskFilter(inner);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 200, 50, paint);

        // 第三个：OUTER
        MaskFilter outer = new BlurMaskFilter(100, BlurMaskFilter.Blur.OUTER);
        paint.setMaskFilter(outer);
        canvas.drawBitmap(bitmap, 100, bitmap.getHeight() + 100, paint);

        // 第四个：SOLID
        //MaskFilter solid = new BlurMaskFilter(100, BlurMaskFilter.Blur.SOLID);
        //paint.setMaskFilter(solid);

        MaskFilter maskFilter = new EmbossMaskFilter(new float[]{1,1,1},0.2f,6,10);
        /**
         *  direction 是一个 3 个元素的数组，指定了光源的方向；
         *  ambient 是环境光的强度，数值范围是 0 到 1；
         *  specular 是炫光的系数；
         *  blurRadius 是应用光线的范围。
         */
        paint.setMaskFilter(maskFilter);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 200, bitmap.getHeight() + 100, paint);
    }
}
