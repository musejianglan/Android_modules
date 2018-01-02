package com.musejianglan.app4md;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.layout_drawer);
        mNavigationView = (NavigationView) findViewById(R.id.view_navigation);

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                String title = (String) item.getTitle();
                Toast.makeText(MainActivity.this, "您点击了 " + title, Toast.LENGTH_SHORT).show();


                item.setChecked(true);
                mDrawerLayout.closeDrawer(mNavigationView);

                return true;
            }
        });

    }
}
