package com.musejianglan.customview;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.musejianglan.customview.view1_1_base.BaseViewActivity;

public class MainActivity extends ListActivity {

    private String[] names = {"自定义 View 1-1 绘制基础"};
    private Class[] activities = {BaseViewActivity.class};

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
