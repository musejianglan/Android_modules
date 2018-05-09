package com.musejianglan.rxjavademo.retrofit_demo;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.musejianglan.rxjavademo.R;
import com.musejianglan.rxjavademo.retrofit_demo.fragment.RetrofitGetFragment;
import com.musejianglan.rxjavademo.retrofit_demo.fragment.RetrofitHeaderFragment;
import com.musejianglan.rxjavademo.retrofit_demo.fragment.RetrofitPostFragment;
import com.musejianglan.rxjavademo.retrofit_demo.fragment.Synch_AsynchFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RetrofitActivity extends AppCompatActivity {

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.pager)
    ViewPager pager;

    List<String> titles = new ArrayList<>();
    List<Fragment> fragments = new ArrayList<>();

    {

        titles.add("retrofit header");
        fragments.add(new RetrofitHeaderFragment());

        titles.add("retrofit 同步 异步");
        fragments.add(new Synch_AsynchFragment());

        titles.add("retrofit GET");
        fragments.add(new RetrofitGetFragment());

        titles.add("retrofit POST");
        fragments.add(new RetrofitPostFragment());


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
        pager.setAdapter(new RetrofitActivity.FragmentAdapter(getSupportFragmentManager()));

        tabLayout.setupWithViewPager(pager);
    }

    class FragmentAdapter extends FragmentPagerAdapter {

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

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
            return titles.get(position);
        }
    }

}
