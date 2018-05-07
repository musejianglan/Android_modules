package com.musejianglan.app4md.activity.bnv;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.musejianglan.app4md.R;
import com.musejianglan.app4md.databinding.ActivityStyleBinding;
import com.promise.bnvexlib.BottomNavigationViewEx;

public class StyleActivity extends AppCompatActivity {

    ActivityStyleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_style);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_style);
        init();
    }

    private void init() {
        binding.bnveNoAnimation.enableAnimation(false);

        binding.bnveNoShiftingMode.enableShiftingMode(false);

        binding.bnveNoItemShiftingMode.enableItemShiftingMode(false);


        binding.bnveNoText.setTextVisibility(false);

        binding.bnveNoIcon.setIconVisibility(false);

        binding.bnveNoAnimationShiftingMode.enableAnimation(false);
        binding.bnveNoAnimationShiftingMode.enableShiftingMode(false);

        binding.bnveNoAnimationItemShiftingMode.enableAnimation(false);
        binding.bnveNoAnimationItemShiftingMode.enableItemShiftingMode(false);


        disableAllAnimation(binding.bnveNoAnimationShiftingModeItemShiftingMode);

        binding.bnveNoShiftingModeItemShiftingModeText.enableShiftingMode(false);
        binding.bnveNoShiftingModeItemShiftingModeText.enableItemShiftingMode(false);
        binding.bnveNoShiftingModeItemShiftingModeText.setTextVisibility(false);


        disableAllAnimation(binding.bnveNoAnimationShiftingModeItemShiftingModeText);
        binding.bnveNoAnimationShiftingModeItemShiftingModeText.setTextVisibility(false);

        binding.bnveNoShiftingModeItemShiftingModeAndIcon.enableShiftingMode(false);
        binding.bnveNoShiftingModeItemShiftingModeAndIcon.enableItemShiftingMode(false);
        binding.bnveNoShiftingModeItemShiftingModeAndIcon.setIconVisibility(false);

        binding.bnveNoItemShiftingModeIcon.enableItemShiftingMode(false);
        binding.bnveNoItemShiftingModeIcon.setIconVisibility(false);

        disableAllAnimation(binding.bnveNoAnimationShiftingModeItemShiftingModeIcon);
        binding.bnveNoAnimationShiftingModeItemShiftingModeIcon.setIconVisibility(false);

        disableAllAnimation(binding.bnveWithPadding);
        binding.bnveWithPadding.setIconVisibility(false);

        initCenterIconOnly();

        initSmallerText();

        initBiggerIcon();

        initCustomTypeface();

        binding.bnveIconSelector.enableAnimation(false);

        initMargin();

        initUncheckedFirstTime();
    }

    private void disableAllAnimation(BottomNavigationViewEx bnve) {
        bnve.enableAnimation(false);
        bnve.enableShiftingMode(false);
        bnve.enableItemShiftingMode(false);
    }

    private void initCenterIconOnly() {
        disableAllAnimation(binding.bnveCenterIconOnly);
        int centerPosition = 2;
        // attention: you must ensure the center menu item title is empty
        // make icon bigger at centerPosition
        binding.bnveCenterIconOnly.setIconSizeAt(centerPosition, 48, 48);
        binding.bnveCenterIconOnly.setItemBackground(centerPosition, R.color.colorGreen);
        binding.bnveCenterIconOnly.setIconTintList(centerPosition,
                getResources().getColorStateList(R.color.selector_item_gray_color));
        binding.bnveCenterIconOnly.setIconMarginTop(centerPosition, BottomNavigationViewEx.dp2px(this, 4));
        // you could set a listener for bnve. and return false when click the center item so that it won't be checked.
        binding.bnveCenterIconOnly.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.menu_add) {
                    Toast.makeText(StyleActivity.this, "add", Toast.LENGTH_SHORT).show();
                    return false;
                }
                return true;
            }
        });
    }

    private void initSmallerText() {
        disableAllAnimation(binding.bnveSmallerText);
        // set text size
        binding.bnveSmallerText.setTextSize(8);
    }

    private void initBiggerIcon() {
        disableAllAnimation(binding.bnveBiggerIcon);
        // hide text
        binding.bnveBiggerIcon.setTextVisibility(false);
        // set icon size
        int iconSize = 36;
        binding.bnveBiggerIcon.setIconSize(iconSize, iconSize);
        // set item height
        binding.bnveBiggerIcon.setItemHeight(BottomNavigationViewEx.dp2px(this, iconSize + 16));
    }

    private void initCustomTypeface() {
        disableAllAnimation(binding.bnveCustomTypeface);
        // set typeface : bold
        binding.bnveCustomTypeface.setTypeface(Typeface.DEFAULT_BOLD);
        // you also could set typeface from file.
//        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/custom.ttf");
//        binding.bnveCustomTypeface.setTypeface(typeface);
    }

    private void initMargin() {
        disableAllAnimation(binding.bnveIconMarginTop);
        binding.bnveIconMarginTop.setTextVisibility(false);
        binding.bnveIconMarginTop.setItemHeight(BottomNavigationViewEx.dp2px(this, 56));
        binding.bnveIconMarginTop.setIconsMarginTop(BottomNavigationViewEx.dp2px(this, 16));
//        binding.bnveIconMarginTop.setIconTintList(0, getResources()
//                .getColorStateList(R.color.colorGray));

    }

    /**
     * There is no idea to set no check item first time.
     * But we can let user think it is unchecked first time by control the color
     */
    private void initUncheckedFirstTime() {
        disableAllAnimation(binding.bnveUncheckedFirstTime);
        // use the unchecked color for first item
        binding.bnveUncheckedFirstTime.setIconTintList(0, getResources()
                .getColorStateList(R.color.colorGray));
        binding.bnveUncheckedFirstTime.setTextTintList(0, getResources()
                .getColorStateList(R.color.colorGray));
        binding.bnveUncheckedFirstTime.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            private boolean firstClick = true;
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // restore the color when click
                if (firstClick) {
                    int position = binding.bnveUncheckedFirstTime.getMenuItemPosition(item);
                    if (0 == position) {
                        firstClick = false;
                        binding.bnveUncheckedFirstTime.setIconTintList(0, getResources()
                                .getColorStateList(R.color.selector_item_primary_color));
                        binding.bnveUncheckedFirstTime.setTextTintList(0, getResources()
                                .getColorStateList(R.color.selector_item_primary_color));
                    }
                }
                // do other
                return true;
            }
        });
    }
}
