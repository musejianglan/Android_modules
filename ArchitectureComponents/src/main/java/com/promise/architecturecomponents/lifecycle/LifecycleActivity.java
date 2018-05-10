package com.promise.architecturecomponents.lifecycle;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.promise.architecturecomponents.R;
import com.promise.architecturecomponents.lifecycle.listeners.DefaultLifecycleListener;
import com.promise.baseutilslib.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class LifecycleActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    ViewPager viewPager;

    List<Fragment> fragments = new ArrayList<>();
    List<String> titls = new ArrayList<>();
    {
        fragments.add(new HomeFragment());
        fragments.add(new BlankFragment());

        titls.add("首页");
        titls.add("其他");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);

        getLifecycle().addObserver(new DefaultLifecycleListener());
        LogUtils.e(this.getClass().getSimpleName() + " >> onCreate");

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titls.get(position);
            }
        });

        tabLayout.setupWithViewPager(viewPager);



    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.e(this.getClass().getSimpleName() + " >> onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.e(this.getClass().getSimpleName() + " >> onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.e(this.getClass().getSimpleName() + " >> onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.e(this.getClass().getSimpleName() + " >> onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.e(this.getClass().getSimpleName() + " >> onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.e(this.getClass().getSimpleName() + " >> onRestart");
    }

}
