package com.musejianglan.rxjavademo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.musejianglan.rxjavademo.bean.GankFuliBean;

import java.util.List;

/**
 * Created by liulei on 2017/12/19.
 */

public class MeiAdapter extends BaseAdapter {

    private List<GankFuliBean.ResultsBean> list;
    private Context context;

    public MeiAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<GankFuliBean.ResultsBean> list) {
        this.list = list;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list!=null?list.size():0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewholder viewholder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_image,null);
            viewholder = new Viewholder();
            viewholder.imageView = convertView.findViewById(R.id.imageview);
            convertView.setTag(viewholder);
        }else {
            viewholder = (Viewholder) convertView.getTag();
        }

        GankFuliBean.ResultsBean resultsBean = list.get(position);
        String url = resultsBean.getUrl();
        Glide.with(context)
                .load(url)
                .fitCenter()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round)
                .into(viewholder.imageView);
        return convertView;
    }

    class Viewholder{
        ImageView imageView;
    }
}
