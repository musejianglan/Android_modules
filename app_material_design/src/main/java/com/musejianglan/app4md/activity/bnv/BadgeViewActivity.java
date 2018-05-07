package com.musejianglan.app4md.activity.bnv;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.musejianglan.app4md.R;
import com.musejianglan.app4md.databinding.ActivityBadgeViewBinding;

import java.util.Random;

import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

public class BadgeViewActivity extends AppCompatActivity {
    ActivityBadgeViewBinding binding;

    Badge badge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_badge_view);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_badge_view);

        initView();
    }

    private void initView() {
        // disable all animations
        binding.bnve.enableAnimation(false);
        binding.bnve.enableShiftingMode(false);
        binding.bnve.enableItemShiftingMode(false);




        binding.btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (badge == null) {
                    // add badge
                    badge = addBadgeAt(2, 1);
                }else {
                    int nextInt = new Random().nextInt(500);
                    badge.setBadgeNumber(nextInt);
                }
            }
        });



    }

    private Badge addBadgeAt(int position, int number) {
        // add badge
        return new QBadgeView(this)
                .setBadgeNumber(number)
                .setExactMode(true)
                .setBadgeGravity(Gravity.END|Gravity.TOP)
                .setGravityOffset(12, 2, true)
                .bindTarget(binding.bnve.getBottomNavigationItemView(position))
                .setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
                    @Override
                    public void onDragStateChanged(int dragState, Badge badge, View targetView) {
                        if (Badge.OnDragStateChangedListener.STATE_SUCCEED == dragState)
                            Toast.makeText(BadgeViewActivity.this, R.string.tips_badge_removed, Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
