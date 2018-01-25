package com.musejianglan.customview;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hencoder.hencoderpracticedraw3.DrawTextActivity;
import com.hencoder.hencoderpracticedraw4.CanvasClipMatrixActivity;
import com.hencoder.hencoderpracticedraw5.View1_5Activity;
import com.hencoder.hencoderpracticedraw6.Animator1Activity;
import com.hencoder.hencoderpracticedraw7.Animator2Activity;
import com.hencoder.hencoderpracticelayout1.LayoutMeasureActivity;
import com.musejianglan.customview.layout2.LayoutMeasure2Activity;
import com.musejianglan.customview.view1_1_base.BaseViewActivity;
import com.musejianglan.customview.view1_2_paint_detail.PaintDetailActivity;

public class MainActivity extends ListActivity {

    private String[] names = {"自定义 View 1-1 绘制基础",
            "自定义 View 1-2 Paint 详解",
            "自定义 View 1-3 drawText() 文字的绘制",
            "自定义 View 1-4 Canvas 对绘制的辅助 clipXXX() 和 Matrix",
            "自定义 View 1-5 绘制顺序",
            "自定义 View 1-6：属性动画 Property Animation（上手篇）",
            "自定义 View 1-7：属性动画 Property Animation（进阶篇）",
            "UI 部分 2-1 布局基础",
            "Android UI 部分 2-2 全新定义 View 的尺寸"};
    private Class[] activities = {BaseViewActivity.class, PaintDetailActivity.class,
            DrawTextActivity.class,CanvasClipMatrixActivity.class, View1_5Activity.class,
            Animator1Activity.class, Animator2Activity.class,LayoutMeasureActivity.class, LayoutMeasure2Activity.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,names));



    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        startActivity(new Intent(MainActivity.this,activities[position]));
    }
}
