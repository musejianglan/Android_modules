package com.promise.architecturecomponents.lifecycle;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.promise.architecturecomponents.R;
import com.promise.architecturecomponents.lifecycle.listeners.FragmentLifecycleListenner;
import com.promise.baseutilslib.LogUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getLifecycle().addObserver(new FragmentLifecycleListenner());
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.e(this.getClass().getSimpleName() + " >> onResume");
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtils.e(this.getClass().getSimpleName() + " >> onStart");
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtils.e(this.getClass().getSimpleName() + " >> onStop");
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtils.e(this.getClass().getSimpleName() + " >> onPause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.e(this.getClass().getSimpleName() + " >> onDestroy");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.e(this.getClass().getSimpleName() + " >> onCreate");
    }
}
