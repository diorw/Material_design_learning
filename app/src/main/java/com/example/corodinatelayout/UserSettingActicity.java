package com.example.corodinatelayout;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.alertdialogpro.AlertDialogPro;

/**
 * Created by wda on 2017/5/24.
 */
public class UserSettingActicity extends AppCompatActivity {
    private EditText GendereditText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_setting_layout);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Toolbar toolbar = (Toolbar) findViewById(R.id.user_toolbar);
        toolbar.setTitle("个人资料");
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorTitle));
        toolbar.inflateMenu(R.menu.user_menu);
        GendereditText = (EditText)findViewById(R.id.gender);
        GendereditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialogPro.Builder builder = new AlertDialogPro.Builder(getApplicationContext());
                builder.setTitle("性别").
                        setMessage("Message Body").
                        setNeutralButton("Neutral", null).
                        setPositiveButton("Positive", null).
                        setNegativeButton("Negative", null).
                        show();
            }
        });
    }
}
