package com.dlong.rep.swiperightbacktest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {
    private Context mContext = this;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected boolean isSupportSwipeBack() {
        return false;  //取消这个页面的划动返回
    }

    public void GoToMenu(View view){
        mIntent = new Intent();
        mIntent.setClass(mContext,MenuActivity.class);
        mContext.startActivity(mIntent);
    }

    public void GoToAdd(View view){
        mIntent = new Intent();
        mIntent.setClass(mContext,AddActivity.class);
        mContext.startActivity(mIntent);
    }
}
