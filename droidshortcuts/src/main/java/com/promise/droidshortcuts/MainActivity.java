package com.promise.droidshortcuts;

import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private final static String ACTION_1 = "action1";
    private final static String ACTION_2 = "action2";
    private final static String ACTION_3 = "action3";
    private static final String SHORTCUT_ID_SEARCH = "1111";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.textView2);

        switch (getIntent().getAction()){
            case ACTION_1:
                textView.setText(ACTION_1);
                break;
            case ACTION_2:
                textView.setText(ACTION_2);
                break;
            case ACTION_3:
                textView.setText(ACTION_3);
                break;
            default:
                break;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
            ShortcutInfo shortcutInfo = new ShortcutInfo.Builder(this, SHORTCUT_ID_SEARCH)
                    .setIcon(Icon.createWithResource(this, R.drawable.ic_directions_bike_black_24dp))
                    .setShortLabel("支付")
                    .setLongLabel("打开支付页面。。。")
                    .setIntent(new Intent(this,PayActivity.class))
//                    .setIntent(new Intent(this, MainActivity.class))
                    .build();

            ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);
            //这样就可以通过长按图标显示出快捷方式了
            shortcutManager.setDynamicShortcuts(Arrays.asList(shortcutInfo));

        }
    }

    public void scanForPay(View view) {
        startActivity(new Intent(MainActivity.this,PayActivity.class));
    }

    public void discover(View view) {
        startActivity(new Intent(MainActivity.this,DiscoverActivity.class));
    }

    public void my(View view) {
        startActivity(new Intent(MainActivity.this,MyActivity.class));
    }
}
