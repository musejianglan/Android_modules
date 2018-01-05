package com.musejianglan.app4md.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.musejianglan.app4md.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by liulei on 2018/1/5.
 */

public class ThemeRecyclerAdapter extends RecyclerView.Adapter<ThemeRecyclerAdapter.VHolder> {

    Context mContext;
    List<String> list;

    public ThemeRecyclerAdapter(Context context) {
        mContext = context;
        this.list = Arrays.asList(context.getResources().getStringArray(R.array.imgurl));
    }

    @Override
    public VHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_them_recycler,parent,false);
        VHolder vHolder = new VHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(VHolder holder, int position) {

        String imgUrl = list.get(position);

        Glide.with(mContext)
                .load(imgUrl)

                .into(holder.imag);

        holder.name.setText(mContext.getString(R.string.app_name)+position);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class VHolder extends RecyclerView.ViewHolder{

        ImageView imag;
        TextView name;
        public VHolder(View itemView) {
            super(itemView);
            imag = itemView.findViewById(R.id.img_pic);
            name = itemView.findViewById(R.id.pic_name);
        }
    }
}
