package com.musejianglan.app4md.activity.tab;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import com.musejianglan.app4md.R;
import com.musejianglan.app4md.activity.BaseActivity;

public class TabWithIconActivity extends BaseActivity {

	private TabLayout fixed_tablayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab_with_icon);

		fixed_tablayout = findViewById(R.id.fixed_tablayout22);

		fixed_tablayout.addTab(fixed_tablayout.newTab().setText("本地").setIcon(R.drawable.home));
		fixed_tablayout.addTab(fixed_tablayout.newTab().setText("国内").setIcon(R.drawable.clound));
		fixed_tablayout.addTab(fixed_tablayout.newTab().setText("国际").setIcon(R.drawable.book));

		fixed_tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
