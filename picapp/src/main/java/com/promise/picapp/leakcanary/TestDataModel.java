package com.promise.picapp.leakcanary;

import android.widget.TextView;

/**
 * Created by liulei on 2017/12/26.
 */

public class TestDataModel {

    private static TestDataModel sInstance;
    private TextView mRetainedTextView;

    public static TestDataModel getInstance() {
        if (sInstance == null) {
            sInstance = new TestDataModel();
        }
        return sInstance;
    }

    public void setRetainedTextView(TextView textView) {
        mRetainedTextView = textView;
    }
}
