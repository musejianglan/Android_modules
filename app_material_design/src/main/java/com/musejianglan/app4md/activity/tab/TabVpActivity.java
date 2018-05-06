package com.musejianglan.app4md.activity.tab;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.musejianglan.app4md.R;
import com.musejianglan.app4md.activity.BaseActivity;
import com.musejianglan.app4md.activity.tab.fragment.FavoriteFragment;
import com.musejianglan.app4md.activity.tab.fragment.HomeFragment;
import com.musejianglan.app4md.activity.tab.fragment.MineFragment;
import com.musejianglan.app4md.activity.tab.fragment.OtherFragment;

import java.util.ArrayList;
import java.util.List;

public class TabVpActivity extends BaseActivity {

	private TabLayout tablayout;
	private ViewPager viewpager;

	private List<Fragment> fragmentList = new ArrayList<>();
	private List<String> titleList = new ArrayList<>();

	{
		fragmentList.add(new HomeFragment());
		titleList.add("首页");

		fragmentList.add(new FavoriteFragment());
		titleList.add("喜欢");

		fragmentList.add(new OtherFragment());
		titleList.add("其他");

		fragmentList.add(new MineFragment());
		titleList.add("我");

		fragmentList.add(new MineFragment());
		titleList.add("我");

		fragmentList.add(new MineFragment());
		titleList.add("我");

		fragmentList.add(new MineFragment());
		titleList.add("我");

		fragmentList.add(new MineFragment());
		titleList.add("我");

		fragmentList.add(new MineFragment());
		titleList.add("我");
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab_vp);

		tablayout = findViewById(R.id.tablayout);

		viewpager = findViewById(R.id.viewpager);

		viewpager.setAdapter(new TabViewPagerAdapter(getSupportFragmentManager(),fragmentList,titleList));

		tablayout.setupWithViewPager(viewpager,false);
	}
}
