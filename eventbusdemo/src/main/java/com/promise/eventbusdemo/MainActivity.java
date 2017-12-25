package com.promise.eventbusdemo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.promise.eventbusdemo.eventbus.EventBusActivity;
import com.promise.eventbusdemo.otto.OttoReceiverActivity;

public class MainActivity extends ListActivity {

    String[] names = {"EventBusActivity------","Otto ----------------------"};
    Class[] clazz = {EventBusActivity.class, OttoReceiverActivity.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,
                names));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        startActivity(new Intent(MainActivity.this,clazz[position]));
    }
}
