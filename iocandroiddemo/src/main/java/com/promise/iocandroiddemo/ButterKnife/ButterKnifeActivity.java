package com.promise.iocandroiddemo.ButterKnife;

import android.graphics.drawable.Drawable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.promise.iocandroiddemo.R;

import butterknife.BindArray;
import butterknife.BindColor;
import butterknife.BindDimen;
import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class ButterKnifeActivity extends BaseActivity {


    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.username)
    EditText mUsername;
    @BindView(R.id.register)
    Button mRegister;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.listview)
    ListView listview;



    //绑定资源

    @BindString(R.string.app_name)
    String appName;
    @BindColor(R.color.colorAccent) int color;
    @BindDrawable(R.mipmap.ic_launcher_round)
    Drawable img;
    @BindDimen(R.dimen.textsize1)
    int margin;
    @BindArray(R.array.arr)
    String[] arrs;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_butter_knife;
    }



    @OnClick(R.id.register)
    public void onViewClicked() {
        Toast.makeText(this,"click----",Toast.LENGTH_SHORT).show();
        mUsername.setText("123123123");


        mTitle.setTextColor(color);
        mTitle.setTextSize(margin);
        mTitle.setText(appName);

        imageView.setImageDrawable(img);
    }

    @Override
    protected void onResume() {
        super.onResume();

        listview.setAdapter(new BKAdapter(arrs,ButterKnifeActivity.this));
    }

    @OnItemClick(R.id.listview)
    public void onListItemClick(int position){

        Toast.makeText(this,arrs[position] + "click----",Toast.LENGTH_SHORT).show();
    }
}
