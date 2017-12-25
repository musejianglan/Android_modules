package com.promise.iocandroiddemo.ButterKnife;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.promise.iocandroiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liulei on 2017/12/25.
 */

public class BKAdapter extends BaseAdapter {

    String[] arr;
    Context mContext;

    public BKAdapter(String[] arr, Context context) {
        this.arr = arr;
        mContext = context;
    }

    @Override
    public int getCount() {
        return arr!=null?arr.length:0;
    }

    @Override
    public Object getItem(int position) {
        return arr[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_bk_text, parent, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        String s = arr[position];
        viewHolder.name.setText(s);
        return convertView;
    }

    class ViewHolder{
        @BindView(R.id.txt_name)
        TextView name;

        public ViewHolder(View view) {
            ButterKnife.bind(this,view);
        }
    }


}
