package com.example.corodinatelayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;

/**
 * Created by wda on 2017/5/24.
 */
public class UserSettingActicity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_setting_layout);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Toolbar toolbar = (Toolbar) findViewById(R.id.user_toolbar);
        toolbar.inflateMenu(R.menu.user_menu);

    }
}
