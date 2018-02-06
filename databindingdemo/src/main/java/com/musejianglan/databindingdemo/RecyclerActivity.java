package com.musejianglan.databindingdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.musejianglan.databindingdemo.adapter.MyRecyclerAdapter;
import com.musejianglan.databindingdemo.bean.UserBean;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView recyclerview;
    private List<UserBean> mList;

    {
        mList = new ArrayList<>();
        int i  = 0;
        while (i < 50) {
            mList.add(new UserBean("name"+i,i*5));
            i++;
        }

    }

    private MyRecyclerAdapter mMyRecyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);


        recyclerview = findViewById(R.id.recyclerview);

        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        mMyRecyclerAdapter = new MyRecyclerAdapter(mList,this);
        recyclerview.setAdapter(mMyRecyclerAdapter);


    }
}
