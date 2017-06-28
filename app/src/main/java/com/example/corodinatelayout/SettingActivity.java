package com.example.corodinatelayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

/**
 * Created by zq on 2017/6/18.
 */

public class SettingActivity extends AppCompatActivity {

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_layout);
        View home = findViewById(R.id.gerenziliao);
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SettingActivity.this,UserSettingActicity.class);
                startActivity(intent);
            }
        });
        Switch wifi=(Switch)findViewById(R.id.switch1);
        wifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(getApplicationContext(), "已打开仅WIFI加载图片",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "已关闭仅WIFI加载图片",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        Switch brightness=(Switch)findViewById(R.id.switch2);
        brightness.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(getApplicationContext(), "已打开自动调节亮度",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "已关闭自动调节亮度",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        Switch sound=(Switch)findViewById(R.id.switch3);
        sound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(getApplicationContext(), "已打开声音",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "已关闭声音",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        Switch message=(Switch)findViewById(R.id.switch4);
        message.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(getApplicationContext(), "已打开消息提醒",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "已关闭消息提醒",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        View huancun = findViewById(R.id.huancun);
        huancun.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
    }
}
