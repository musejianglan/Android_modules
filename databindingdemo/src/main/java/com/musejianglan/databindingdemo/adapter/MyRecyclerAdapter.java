package com.musejianglan.databindingdemo.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.musejianglan.databindingdemo.R;
import com.musejianglan.databindingdemo.bean.UserBean;
import com.musejianglan.databindingdemo.databinding.ItemUserBinding;

import java.util.List;

/**
 * Created by liulei on 2018/2/6.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<UserBean> mList;
    private Context mContext;

    public MyRecyclerAdapter(List<UserBean> list, Context context) {
        mList = list;
        mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        ItemUserBinding itemUserBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_user,parent,false);

        return new MyViewHolder(itemUserBinding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ItemUserBinding itemUserBinding = holder.getItemUserBinding();
        UserBean userBean = mList.get(position);
        itemUserBinding.setUser(userBean);
        itemUserBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mList!=null?mList.size():0;
    }
}
