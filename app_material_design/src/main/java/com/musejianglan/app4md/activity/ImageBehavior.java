package com.musejianglan.app4md.activity;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by liulei on 2018/1/5.
 */

public class ImageBehavior extends CoordinatorLayout.Behavior<ImageView> {

    private int width;//屏幕宽度



    public ImageBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        DisplayMetrics display = context.getResources().getDisplayMetrics();
        width = display.widthPixels;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, ImageView child, View dependency) {
        //返回true，child跟随dependency移动，false不跟随
        return dependency instanceof Button;
    }

    /**
     * @param parent
     * @param child
     * @param dependency
     * @return 返回true表示child的位置或者是宽高要发生改变，否则就返回false
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, ImageView child, View dependency) {
        int top = dependency.getTop();//0
        int left = dependency.getLeft();//0

        int dependencyX = (int) dependency.getX();
        int dependencyY = (int) dependency.getY();
        Log.d("123",dependencyY+"------"+dependencyX);
        Log.d("123",top+"------"+left);
        child.setY(dependencyY);
        child.setX(width - dependencyX - dependency.getWidth());

        return true;
    }
}
