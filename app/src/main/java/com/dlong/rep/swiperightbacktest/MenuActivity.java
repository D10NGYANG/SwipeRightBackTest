package com.dlong.rep.swiperightbacktest;

import android.os.Bundle;
import android.view.View;

public class MenuActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void Back(View view){
        finish();
    }
}
