package com.musejianglan.databindingdemo.eventdeal;

import android.view.View;
import android.widget.Toast;

/**
 * @author: liulei
 * @date:2018/4/24
 */
public class MyHandler {

    public void onViewClick(View view){

        Toast.makeText(view.getContext(), "aaaaaa", Toast.LENGTH_SHORT).show();
    }

}
