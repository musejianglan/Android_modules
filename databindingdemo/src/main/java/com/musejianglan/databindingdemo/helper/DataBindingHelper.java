package com.musejianglan.databindingdemo.helper;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.musejianglan.databindingdemo.R;

/**
 * Created by liulei on 2018/2/7.
 */

public class DataBindingHelper {


    /**
     * 1.加载图片,无需手动调用此方法
     * 2.使用@BindingAdapter注解设置自定义属性的名称，imageUrl就是属性的名称，
     * 当ImageView中使用imageUrl属性时，会自动调用loadImage方法，
     * @param imageView 控件
     * @param url 属性值
     */
    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView,String url){

        //Glid
        Glide.with(imageView.getContext())
                .load(url)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher_round)
                .into(imageView);

    }
}
