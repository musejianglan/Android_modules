package com.musejianglan.customview;

import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;

/**
 * Created by liulei on 2018/1/24.
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
