package com.musejianglan.rxjavademo;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.musejianglan.rxjavademo.fragment.ChainingOperatorsMapFragment;
import com.musejianglan.rxjavademo.fragment.RxBaseFragment;
import com.musejianglan.rxjavademo.fragment.ThreadSchedulingFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.pager)
    ViewPager pager;

    List<String> titles = new ArrayList<>();
    List<Fragment> fragments = new ArrayList<>();

    {

        titles.add("基本用法");
        fragments.add(new RxBaseFragment());

        titles.add("线程调度");
        fragments.add(new ThreadSchedulingFragment());

        titles.add("操作符-map");
        fragments.add(new ChainingOperatorsMapFragment());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);
        pager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));

        tabLayout.setupWithViewPager(pager);
    }

    class FragmentAdapter extends FragmentPagerAdapter{

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
