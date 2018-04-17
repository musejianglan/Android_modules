package com.promise.iocandroiddemo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.promise.iocandroiddemo.ButterKnife.ButterKnifeActivity;
import com.promise.iocandroiddemo.ButterKnife.FragmentsActivity;
import com.promise.iocandroiddemo.dagger.Dagger2Activity;

import dagger.android.DaggerActivity;

public class MainActivity extends ListActivity {

    String[] names = {"ButterKnifeActivity","FragmentsActivity","Dagger2"};
    Class[] clazz = {ButterKnifeActivity.class,FragmentsActivity.class, Dagger2Activity.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        startActivity(new Intent(MainActivity.this,clazz[position]));
    }
}
