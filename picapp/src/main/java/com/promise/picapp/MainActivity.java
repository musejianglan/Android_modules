package com.promise.picapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.promise.picapp.fresco.FrescoActivity;
import com.promise.picapp.glide.GlideActivity;
import com.promise.picapp.glide.GlideListActivity;
import com.promise.picapp.leakcanary.CanaryActivity;
import com.promise.picapp.picasso.PicassoActivity;
import com.promise.picapp.webp.WebpActivity;

public class MainActivity extends ListActivity {

    String[] actName = {"Glide","GlideListActivity","picasso:picasso","facebook:fresco","内存检测","webp图片格式"};
    Class[] clazz = {GlideActivity.class,GlideListActivity.class,PicassoActivity.class, FrescoActivity.class,
            CanaryActivity.class, WebpActivity.class
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        setListAdapter(new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,
                actName));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if (position < clazz.length) {
            startActivity(new Intent(MainActivity.this,clazz[position]));
        }

    }
}
