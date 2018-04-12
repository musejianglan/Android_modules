package com.promise.animationdemo;

import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;

/**
 * @author: liulei
 * @date:2018/4/12
 */
public class PageModel {

    @LayoutRes
    public int sampleLayoutRes;
    @StringRes
    public int titleRes;
    @LayoutRes
    public int practiceLayoutRes;

    public PageModel(@LayoutRes int sampleLayoutRes, @StringRes int titleRes, @LayoutRes int practiceLayoutRes) {
        this.sampleLayoutRes = sampleLayoutRes;
        this.titleRes = titleRes;
        this.practiceLayoutRes = practiceLayoutRes;
    }
}
