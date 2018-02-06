package com.musejianglan.databindingdemo.adapter;

import android.support.v7.widget.RecyclerView;

import com.musejianglan.databindingdemo.databinding.ItemUserBinding;

/**
 * Created by liulei on 2018/2/6.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    private ItemUserBinding itemUserBinding;

    public ItemUserBinding getItemUserBinding() {
        return itemUserBinding;
    }

    public MyViewHolder(ItemUserBinding itemUserBinding) {
        super(itemUserBinding.getRoot());
        this.itemUserBinding = itemUserBinding;
    }
}
