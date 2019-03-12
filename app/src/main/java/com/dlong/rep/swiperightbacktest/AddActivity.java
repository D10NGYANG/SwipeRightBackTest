package com.dlong.rep.swiperightbacktest;

import android.os.Bundle;
import android.view.View;

public class AddActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    public void Back(View view){
        finish();
    }
}
