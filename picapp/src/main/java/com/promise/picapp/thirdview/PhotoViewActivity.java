package com.promise.picapp.thirdview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bm.library.PhotoView;
import com.promise.picapp.R;

public class PhotoViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);
        PhotoView photoView = (PhotoView) findViewById(R.id.img);
// 启用图片缩放功能
        photoView.enable();
    }
}
