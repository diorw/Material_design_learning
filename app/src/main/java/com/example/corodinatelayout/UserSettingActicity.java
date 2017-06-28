package com.example.corodinatelayout;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;

import com.gc.materialdesign.views.CheckBox;

import java.util.Calendar;


/**
 * Created by wda on 2017/5/24.
 */
public class UserSettingActicity extends AppCompatActivity {
    private EditText birthday;
    private CheckBox checkBoxMan,checkBoxWomen;
    private Calendar calendar;
    private int year;
    private int month;
    private int day;
    private DatePicker datePicker;
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
        birthday = (EditText)findViewById(R.id.birthday);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
        birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dpd=new DatePickerDialog(UserSettingActicity.this,Datelistener,year,month,day);
                dpd.show();//显示DatePickerDialog组件
            }
        });
        checkBoxMan = (CheckBox)findViewById(R.id.checkboxMan);
        checkBoxWomen=(CheckBox)findViewById(R.id.checkboxWomen);
        checkBoxMan.setOncheckListener(new CheckBox.OnCheckListener() {
            @Override
            public void onCheck(CheckBox checkBox, boolean b) {
                if(b){
                    checkBoxWomen.setChecked(false);
                }else{
                    checkBoxWomen.setChecked(true);
                }
            }
        });
        checkBoxWomen.setOncheckListener(new CheckBox.OnCheckListener() {
            @Override
            public void onCheck(CheckBox checkBox, boolean b) {
                if(b){
                    checkBoxMan.setChecked(false);
                }else{
                    checkBoxMan.setChecked(true);
                }
            }
        });
    }
    private DatePickerDialog.OnDateSetListener Datelistener=new DatePickerDialog.OnDateSetListener()
    {
        /**params：view：该事件关联的组件
         * params：myyear：当前选择的年
         * params：monthOfYear：当前选择的月
         * params：dayOfMonth：当前选择的日
         */
        @Override
        public void onDateSet(DatePicker view, int myyear, int monthOfYear,int dayOfMonth) {


            //修改year、month、day的变量值，以便以后单击按钮时，DatePickerDialog上显示上一次修改后的值
            year=myyear;
            month=monthOfYear;
            day=dayOfMonth;
            //更新日期
            updateDate();

        }
        //当DatePickerDialog关闭时，更新日期显示
        private void updateDate()
        {
            //在TextView上显示日期
            birthday.setText(year+"-"+(month+1)+"-"+day);
        }
    };
}
