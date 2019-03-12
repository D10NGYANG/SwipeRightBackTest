package com.dlong.rep.swiperightbacktest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.View;
import android.view.ViewGroup;

import com.dlong.rep.swiperightbacktest.view.PageEnabledSlidingPaneLayout;

import java.lang.reflect.Field;

/**
 * s所有活动都要继承这个基础活动即可实现右划返回的功能
 * @author  dlong
 * created at 2019/3/12 4:18 PM
 */
public class BaseActivity extends FragmentActivity implements PageEnabledSlidingPaneLayout.PanelSlideListener{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 初始化划动返回
        initSwipeBackFinish();
    }

    /**
     * 初始化滑动返回
     */
    private void initSwipeBackFinish() {
        if (isSupportSwipeBack()) {
            PageEnabledSlidingPaneLayout slidingPaneLayout = new PageEnabledSlidingPaneLayout(this);
            // 通过反射改变mOverhangSize的值为0，这个mOverhangSize值为菜单到右边屏幕的最短距离，默认
            // 是32dp，现在给它改成0
            try {
                // 属性
                Field f_overHang = SlidingPaneLayout.class.getDeclaredField("mOverhangSize");
                f_overHang.setAccessible(true);
                f_overHang.set(slidingPaneLayout, 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 设置划动监听器
            slidingPaneLayout.setPanelSlideListener(this);
            // slidingPaneLayout.setSliderFadeColor(getResources().getColor(android.R.color.transparent));
            // 这里可以自行设置显示或消失时的前景颜色
            slidingPaneLayout.setSliderFadeColor(Color.GRAY);
            slidingPaneLayout.setCoveredFadeColor(Color.GRAY);

            View leftView = new View(this);
            leftView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            slidingPaneLayout.addView(leftView, 0);

            ViewGroup decor = (ViewGroup) getWindow().getDecorView();
            ViewGroup decorChild = (ViewGroup) decor.getChildAt(0);
            decorChild.setBackgroundColor(getResources().getColor(android.R.color.white));
            decor.removeView(decorChild);
            decor.addView(slidingPaneLayout);
            slidingPaneLayout.addView(decorChild, 1);
        }
    }

    /**
     * 是否支持滑动返回
     * 默认支持
     * 如果想不支持，例如app的首页，只需要复写这个，return false;即可
     * @return
     */
    protected boolean isSupportSwipeBack() {
        return true;
    }

    @Override
    public void onPanelSlide(@NonNull View view, float v) {

    }

    @Override
    public void onPanelOpened(@NonNull View view) {
        // 结束活动
        finish();
        // 添加动画
        this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    @Override
    public void onPanelClosed(@NonNull View view) {

    }
}
