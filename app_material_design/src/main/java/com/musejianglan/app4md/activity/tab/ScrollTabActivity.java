package com.musejianglan.app4md.activity.tab;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.musejianglan.app4md.R;
import com.musejianglan.app4md.activity.BaseActivity;

public class ScrollTabActivity extends BaseActivity {

	private TabLayout scroll_tablayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scroll_tab);

		scroll_tablayout = findViewById(R.id.scroll_tablayout);

		scroll_tablayout.addTab(scroll_tablayout.newTab().setText("本地"));
		scroll_tablayout.addTab(scroll_tablayout.newTab().setText("国内"));
		scroll_tablayout.addTab(scroll_tablayout.newTab().setText("国际"));
		scroll_tablayout.addTab(scroll_tablayout.newTab().setText("音乐"));
		scroll_tablayout.addTab(scroll_tablayout.newTab().setText("电影"));
		scroll_tablayout.addTab(scroll_tablayout.newTab().setText("中国"));
		scroll_tablayout.addTab(scroll_tablayout.newTab().setText("美国"));
		scroll_tablayout.addTab(scroll_tablayout.newTab().setText("英国"));
		scroll_tablayout.addTab(scroll_tablayout.newTab().setText("国说道说道际"));
		scroll_tablayout.addTab(scroll_tablayout.newTab().setText("国的困难的际"));

		scroll_tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
			@Override
			public void onTabSelected(TabLayout.Tab tab) {
				String text = tab.getText().toString();

				toast("onTabSelected:"+text);
			}

			@Override
			public void onTabUnselected(TabLayout.Tab tab) {
				String text = tab.getText().toString();
				toast("onTabUnselected:"+text);
			}

			@Override
			public void onTabReselected(TabLayout.Tab tab) {
				String text = tab.getText().toString();
				toast("onTabReselected:"+text);
			}
		});
	}
}
