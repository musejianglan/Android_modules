package com.promise.mvvmdemo.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.promise.mvvmdemo.R;
import com.promise.mvvmdemo.bean.Meizi;
import com.promise.mvvmdemo.databinding.ItemMeiziBinding;

import java.util.List;

/**
 * @author: liulei
 * @date:2018/5/10
 */
public class MeizhiAdapter extends RecyclerView.Adapter<MeizhiAdapter.Viewholder>{
    private List<Meizi> mList;
    private Context mContext;

    public MeizhiAdapter (Context context) {
        mContext = context;
    }

    public void setmList(List<Meizi> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ItemMeiziBinding itemMeiziBinding= DataBindingUtil.inflate(inflater, R.layout.item_meizi,parent,false);
        return new Viewholder(itemMeiziBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        Meizi meizi = mList.get(position);
        ItemMeiziBinding itemMeiziBinding = holder.getItemMeiziBinding();
        itemMeiziBinding.setMeizhi(meizi);

    }

    @Override
    public int getItemCount() {
        return mList!=null?mList.size():0;
    }

    class Viewholder extends RecyclerView.ViewHolder{
        ItemMeiziBinding itemMeiziBinding;

        public ItemMeiziBinding getItemMeiziBinding() {
            return itemMeiziBinding;
        }

        public Viewholder(ItemMeiziBinding itemMeiziBinding) {
            super(itemMeiziBinding.getRoot());
            this.itemMeiziBinding = itemMeiziBinding;
        }
    }
}
