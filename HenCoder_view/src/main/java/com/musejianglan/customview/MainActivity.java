package com.musejianglan.customview;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hencoder.hencoderpracticedraw3.DrawTextActivity;
import com.hencoder.hencoderpracticedraw4.CanvasClipMatrixActivity;
import com.musejianglan.customview.view1_1_base.BaseViewActivity;
import com.musejianglan.customview.view1_2_paint_detail.PaintDetailActivity;

public class MainActivity extends ListActivity {

    private String[] names = {"自定义 View 1-1 绘制基础","自定义 View 1-2 Paint 详解",
            "自定义 View 1-3 drawText() 文字的绘制","自定义 View 1-4 Canvas 对绘制的辅助 clipXXX() 和 Matrix"};
    private Class[] activities = {BaseViewActivity.class, PaintDetailActivity.class,
            DrawTextActivity.class,CanvasClipMatrixActivity.class};

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
