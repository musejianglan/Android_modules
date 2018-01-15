package com.musejianglan.app4md.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.musejianglan.app4md.R;
import com.musejianglan.app4md.fragment.HomeFragment;
import com.musejianglan.app4md.fragment.SettingFragment;
import com.musejianglan.app4md.fragment.ThemeFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private Toolbar toolbar;

    /*创建一个Drawerlayout和Toolbar联动的开关*/
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();


        addToolbar();


        navClick();

        openFragment(HomeFragment.newInstance());//

    }

    private void initView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.layout_drawer);
        mNavigationView = (NavigationView) findViewById(R.id.view_navigation);
        toolbar = findViewById(R.id.toolbar);
        /*去掉navigation中的滑动条*/
        mNavigationView.getChildAt(0).setVerticalScrollBarEnabled(false);
    }

    private void navClick() {
        mNavigationView.setNavigationItemSelectedListener(this);
    }

    private void addToolbar() {
    /*设置ActionBar*/
        setSupportActionBar(toolbar);
        /*显示Home图标*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*设置Drawerlayout的开关,并且和Home图标联动*/
        toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, 0, 0);
        mDrawerLayout.addDrawerListener(toggle);
        /*同步drawerlayout的状态*/
        toggle.syncState();
    }

    public void openFragment(Fragment fragment){

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content,fragment);
        fragmentTransaction.commit();

    }

    public void openActivity(Class clazz){

        startActivity(new Intent(MainActivity.this,clazz));

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        String title = (String) item.getTitle();
        Toast.makeText(MainActivity.this, "您点击了 " + title, Toast.LENGTH_SHORT).show();

        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.home:
                //
                openFragment(HomeFragment.newInstance());
                break;
            case R.id.theme:
                //
                openFragment(ThemeFragment.newInstance());
                break;
            case R.id.settings:
                //
                openFragment(SettingFragment.newInstance(1));
                break;
            case R.id.tablayout:
                //tablayout
                openActivity(TabLayoutActivity.class);
                break;
            case R.id.ablum:
                //
                openActivity(BottomNaActivity.class);
                break;
            case R.id.friends:
                //
                openActivity(ScrollingActivity.class);
                break;
            case R.id.CoordinatorLayout:
                //
                openActivity(CoordinatorLayoutActivity.class);
                break;
            case R.id.Toolbar:
                //
                openActivity(ToolbarActivity.class);
                break;
            case R.id.constraintLayout:
                openActivity(ConstraintLayoutActivity.class);
                break;

        }

        item.setChecked(true);
        //mDrawerLayout.closeDrawer(mNavigationView);

        return true;
    }
}
