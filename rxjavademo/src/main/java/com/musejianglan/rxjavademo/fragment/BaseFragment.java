package com.musejianglan.rxjavademo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author: liulei
 * @date:2018/5/3
 */
public abstract class BaseFragment extends Fragment {

    public static final String TAG = "RxJava";

    private boolean isFirstVisible = true;
    private boolean isFirstInvisible = true;

    private boolean isViewCreated;
    private boolean isUIVisible;





    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewCreated = true;
        lazyLoad(); // 执行懒加载,因为无法确定setUserVisibleHint和onViewCreated哪个方法先执行，因此两个方法里面都需要调用lazyLoad
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            isUIVisible = true; //当前fragment可见
            if (isFirstVisible) {
                //如果是第一次可见，则进行懒加载
                isFirstVisible = false;
                lazyLoad();
            } else {
                //不是第一次可见，则调用onUserVisible()
                onUserVisible();
            }
        } else {
            isUIVisible = false;
            if (isFirstInvisible) {
                isFirstInvisible = false;
                //第一次不可见
                onFirstUserInvisible();
            } else {
                //非第一次不可见
                onUserInvisible();
            }
        }
    }

    private void lazyLoad() {
        if (isViewCreated && isUIVisible) { //需要进行双重判断，避免因为setUserVisibleHint先于onViewCreaetd调用时，出现空指针
            Log.e(TAG, this.getClass().getSimpleName()  + "lazyLoad");
            initViewsAndEvents();
            onFirstUserVisible();  //进行初次可见时的加载
        }else {
            Log.e(TAG, this.getClass().getSimpleName()  + ">>>>isViewCreated:" + isViewCreated + "------>>>>>isUIVisible:" + isUIVisible);
        }
    }



    protected abstract void initViewsAndEvents();

    protected abstract void onFirstUserVisible();

    protected abstract void onUserVisible();

    protected abstract void onFirstUserInvisible();

    protected abstract void onUserInvisible();
}
