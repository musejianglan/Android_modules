package com.musejianglan.app4md.activity.bnv;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.MenuItem;

import com.musejianglan.app4md.R;
import com.musejianglan.app4md.activity.bnv.fragment.BlankFragment;
import com.musejianglan.app4md.databinding.ActivityWithViewPagerBinding;

import java.util.ArrayList;
import java.util.List;

public class WithViewPagerActivity extends AppCompatActivity {

    private static final String TAG = WithViewPagerActivity.class.getSimpleName();
    private ActivityWithViewPagerBinding binding;
    private VpAdapter adapter;

    // collections
    private SparseIntArray items;// used for change ViewPager selected item
    private List<Fragment> fragments;// used for ViewPager adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_with_view_pager);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_with_view_pager);
        initView();
        initData();
        initEvent();
    }

    /**
     * change BottomNavigationViewEx style
     */
    private void initView() {
        binding.bnve.enableItemShiftingMode(false);
        binding.bnve.enableAnimation(false);
        binding.bnve.enableShiftingMode(false);
    }

    /**
     * create fragments
     */
    private void initData() {
        fragments = new ArrayList<>(3);
        items = new SparseIntArray(3);

        // create music fragment and add it
        BlankFragment musicFragment = BlankFragment.newInstance(getString(R.string.music));
        BlankFragment backupFragment = BlankFragment.newInstance(getString(R.string.backup));
        BlankFragment friendsFragment = BlankFragment.newInstance(getString(R.string.friends));


        // add to fragments for adapter
        fragments.add(musicFragment);
        fragments.add(backupFragment);
        fragments.add(friendsFragment);

        // add to items for change ViewPager item
        items.put(R.id.i_music, 0);
        items.put(R.id.i_backup, 1);
        items.put(R.id.i_friends, 2);

        // set adapter
        adapter = new VpAdapter(getSupportFragmentManager(), fragments);
        binding.vp.setAdapter(adapter);
    }

    /**
     * set listeners
     */
    private void initEvent() {
        // set listener to change the current item of view pager when click bottom nav item
        binding.bnve.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            private int previousPosition = -1;

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                int id = 0;
//                switch (item.getItemId()) {
//                    case R.id.menu_music:
//                        id = 0;
//                        break;
//                    case R.id.menu_backup:
//                        id = 1;
//                        break;
//                    case R.id.menu_friends:
//                        id = 2;
//                        break;
//                }
//                if(previousPosition != id) {
//                  bind.vp.setCurrentItem(id, false);
//                  previousPosition = id;
//                }

                // you can write as above.
                // I recommend this method. You can change the item order or counts without update code here.
                int position = items.get(item.getItemId());
                if (previousPosition != position) {
                    // only set item when item changed
                    previousPosition = position;
                    Log.i(TAG, "-----bnve-------- previous item:" + binding.bnve.getCurrentItem() + " current item:" + position + " ------------------");
                    binding.vp.setCurrentItem(position);
                }
                return true;
            }
        });

        // set listener to change the current checked item of bottom nav when scroll view pager
        binding.vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.i(TAG, "-----ViewPager-------- previous item:" + binding.bnve.getCurrentItem() + " current item:" + position + " ------------------");
                binding.bnve.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

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
