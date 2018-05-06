package com.musejianglan.app4md.activity.tab;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.musejianglan.app4md.R;
import com.musejianglan.app4md.activity.tab.TabViewPagerAdapter;
import com.musejianglan.app4md.activity.tab.fragment.FavoriteFragment;
import com.musejianglan.app4md.activity.tab.fragment.HomeFragment;
import com.musejianglan.app4md.activity.tab.fragment.MineFragment;
import com.musejianglan.app4md.activity.tab.fragment.OtherFragment;

import java.util.ArrayList;
import java.util.List;

import q.rorbin.badgeview.QBadgeView;

public class TabBottomVpActivity extends AppCompatActivity {

	private TabLayout tablayout;
	private ViewPager viewpager;

	private List<Fragment> fragmentList = new ArrayList<>();
	private List<String> titleList = new ArrayList<>();
	private List<Integer> iconList = new ArrayList<>();

	{
		fragmentList.add(new HomeFragment());
		titleList.add("首页");
		iconList.add(R.drawable.home_selector);

		fragmentList.add(new FavoriteFragment());
		titleList.add("喜欢");
		iconList.add(R.drawable.favorite_selector);

		fragmentList.add(new OtherFragment());
		titleList.add("其他");
		iconList.add(R.drawable.other_selector);

		fragmentList.add(new MineFragment());
		titleList.add("我");
		iconList.add(R.drawable.mine_selector);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab_bottom_vp);

		tablayout = findViewById(R.id.tablayout);

		viewpager = findViewById(R.id.viewpager);

		viewpager.setAdapter(new TabViewPagerAdapter(getSupportFragmentManager(),fragmentList,titleList));

		tablayout.setupWithViewPager(viewpager);

		for (int i = 0; i < titleList.size(); i++) {
			TabLayout.Tab tabAt = tablayout.getTabAt(i);
			tabAt.setText(titleList.get(i)).setIcon(iconList.get(i));

//			if (i == 2) {
////				((ViewGroup) mTabLayout.getChildAt(0)).getChildAt(i)
//				View childAt = ((ViewGroup) tablayout.getChildAt(0)).getChildAt(i);
//				new QBadgeView(getApplicationContext()).bindTarget(childAt).setBadgeNumber(5);
//			}
		}
	}
}
