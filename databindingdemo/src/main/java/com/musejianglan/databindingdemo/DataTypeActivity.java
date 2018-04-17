package com.musejianglan.databindingdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.musejianglan.databindingdemo.databinding.ActivityDataTypeBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_data_type);

        ActivityDataTypeBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_data_type);
        binding.setNums(200);
        binding.setStr("this is a string");

        List<String> list = new ArrayList<>();
        list.add("1321321321");
        list.add("asdfasdf");
        list.add("3213asdfas");

        Map<String,String> map = new HashMap<>();

        map.put("key","5456464");
        map.put("key2","asdfasdf");

        String[] arrays = new String[]{"rrrrr","eeee"};

//        binding.setListsss(list);
//
//        binding.setMappp(map);

        binding.setArray(arrays);
    }
}
