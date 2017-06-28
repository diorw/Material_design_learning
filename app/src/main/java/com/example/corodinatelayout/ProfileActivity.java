package com.example.corodinatelayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.ScrollerCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;
import android.util.Log;
import android.annotation.SuppressLint;
import android.app.Activity;

/**
 * Created by zq on 2017/6/18.
 */

public class ProfileActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    private static final int REFRESH_COMPLETE = 0X110;
    private SwipeRefreshLayout mSwipeLayout;
    private Handler mHandler = new Handler()
    {
        public void handleMessage(android.os.Message msg)
        {
            switch (msg.what)
            {
                case REFRESH_COMPLETE:
                    Toast.makeText(getApplicationContext(), "刷新成功",
                            Toast.LENGTH_SHORT).show();
                    mSwipeLayout.setRefreshing(false);
                    break;

            }
        };
    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);
        mSwipeLayout = (SwipeRefreshLayout) findViewById(R.id.id_swipe_ly);
        mSwipeLayout.setOnRefreshListener(this);
        mSwipeLayout.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light,
                android.R.color.holo_orange_light, android.R.color.holo_red_light);
        Button guanzhu =(Button)findViewById(R.id.guanzhu);
        guanzhu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ProfileActivity.this,ListActivity.class);
                startActivity(intent);
            }
        });
        Button fensi =(Button)findViewById(R.id.fensi);
        fensi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ProfileActivity.this,ListActivity.class);
                startActivity(intent);
            }
        });
        Button shoucang =(Button)findViewById(R.id.shoucang);
        shoucang.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ProfileActivity.this,GalleryActivity.class);
                startActivity(intent);
            }
        });
    }
    public void onRefresh()
    {
        // Log.e("xxx", Thread.currentThread().getName());
        // UI Thread

        mHandler.sendEmptyMessageDelayed(REFRESH_COMPLETE, 2000);

    }
}
