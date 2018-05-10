package com.promise.architecturecomponents.lifecycle.listeners;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;

import com.promise.baseutilslib.LogUtils;

/**
 * @author: liulei
 * @date:2018/5/10
 */
public class FragmentLifecycleListenner implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    protected void onCreate(LifecycleOwner owner) {
        LogUtils.e(this.getClass().getSimpleName() + " >> onCreate");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    protected void onResume(LifecycleOwner owner) {
        LogUtils.e(this.getClass().getSimpleName() + " >> onResume");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    protected void onStart(LifecycleOwner owner) {
        LogUtils.e(this.getClass().getSimpleName() + " >> onStart");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    protected void onStop(LifecycleOwner owner) {
        LogUtils.e(this.getClass().getSimpleName() + " >> onStop");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    protected void onPause(LifecycleOwner owner) {
        LogUtils.e(this.getClass().getSimpleName() + " >> onPause");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    protected void onDestroy(LifecycleOwner owner) {
        LogUtils.e(this.getClass().getSimpleName() + " >> onDestroy");
    }
}
