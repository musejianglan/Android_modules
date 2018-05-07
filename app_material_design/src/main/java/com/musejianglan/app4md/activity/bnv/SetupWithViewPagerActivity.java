package com.musejianglan.app4md.activity.bnv;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.musejianglan.app4md.R;
import com.musejianglan.app4md.activity.bnv.fragment.BlankFragment;
import com.musejianglan.app4md.databinding.ActivityWithViewPagerBinding;

import java.util.ArrayList;
import java.util.List;

public class SetupWithViewPagerActivity extends AppCompatActivity {

    private static final String TAG = SetupWithViewPagerActivity.class.getSimpleName();
    private ActivityWithViewPagerBinding binding;
    private VpAdapter adapter;

    // collections
    private List<Fragment> fragments;// used for ViewPager adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_setup_with_view_pager);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_with_view_pager);

        initView();
        initData();
        initEvent();
    }

    private void initView() {
        binding.bnve.enableItemShiftingMode(false);
        binding.bnve.enableAnimation(false);
        binding.bnve.enableShiftingMode(false);

        binding.bnve.setTextVisibility(false);
    }

    /**
     * create fragments
     */
    private void initData() {
        fragments = new ArrayList<>(3);

        // create music fragment and add it
        BlankFragment musicFragment = BlankFragment.newInstance(getString(R.string.music));
        BlankFragment backupFragment = BlankFragment.newInstance(getString(R.string.backup));
        BlankFragment friendsFragment = BlankFragment.newInstance(getString(R.string.friends));
        BlankFragment favorFragment = BlankFragment.newInstance(getString(R.string.favor));


        // add to fragments for adapter
        fragments.add(musicFragment);
        fragments.add(backupFragment);
        fragments.add(friendsFragment);
        fragments.add(favorFragment);

        // set adapter
        adapter = new VpAdapter(getSupportFragmentManager(), fragments);
        binding.vp.setAdapter(adapter);

        // binding with ViewPager
        binding.bnve.setupWithViewPager(binding.vp);
    }

    /**
     * set listeners
     */
    private void initEvent() {
        // set listener to do something then item selected
        binding.bnve.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.d(TAG, item.getItemId() + " item was selected-------------------");
                // you can return false to cancel select
                return true;
            }
        });

    }

    /**
     * view pager adapter
     */
    private static class VpAdapter extends FragmentPagerAdapter {
        private List<Fragment> data;

        public VpAdapter(FragmentManager fm, List<Fragment> data) {
            super(fm);
            this.data = data;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Fragment getItem(int position) {
            return data.get(position);
        }
    }
}
