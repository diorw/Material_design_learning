package com.example.corodinatelayout;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.ActionMenuItem;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.gc.materialdesign.views.CheckBox;

import net.steamcrafted.materialiconlib.MaterialDrawableBuilder;

import org.w3c.dom.Text;

import java.util.Calendar;
/**
 * Created by wda on 2017/5/24.
 */
public class UserSettingActicity extends AppCompatActivity {
    private EditText birthday;
    private EditText name;
    private EditText email;
    private EditText introduce;
    private CheckBox checkBoxMan,checkBoxWomen;
    private Calendar calendar;
    private int year;
    private int month;
    private int day;
    private ActionMenuItemView ok;
    private DatePicker datePicker;
    private String Birthday;
    private String Name;
    private String Introduce;
    private String Email;
    private int gender;
    private UserDao userDao;
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
        name = (EditText)findViewById(R.id.user_name);
        introduce = (EditText)findViewById(R.id.introduce);
        email = (EditText)findViewById(R.id.email);
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
                    gender = 1;
                    checkBoxWomen.setChecked(false);
                }else{
                    gender = 0;
                    checkBoxWomen.setChecked(true);
                }
            }
        });
        checkBoxWomen.setOncheckListener(new CheckBox.OnCheckListener() {
            @Override
            public void onCheck(CheckBox checkBox, boolean b) {
                if(b){
                    gender = 0;
                    checkBoxMan.setChecked(false);
                }else{
                    gender = 1;
                    checkBoxMan.setChecked(true);
                }
            }
        });

        DaoMaster.DevOpenHelper devopenhelper = new DaoMaster.DevOpenHelper(getApplicationContext(),"user-db",null);
        DaoMaster daomaster = new DaoMaster(devopenhelper.getWritableDatabase());
        DaoSession daosession = daomaster.newSession();
        userDao = daosession.getUserDao();
        //暂时添加的用户 id为1，测试用
      /*  User userTemp = new User(1,"wda",null,null,null,1);
        userDao.insert(userTemp);*/

        User user = userDao.queryBuilder().where(UserDao.Properties.Id.eq(1)).build().unique();
        name.setText(user.getUsername());
        birthday.setText(user.getBirthday());
        introduce.setText(user.getIntroduce());
        if(user.getGender()==1){
            checkBoxWomen.setChecked(true);
            checkBoxMan.setChecked(false);
        }else{
            checkBoxMan.setChecked(false);
            checkBoxWomen.setChecked(true);
        }
        email.setText(user.getEmail());


        ok = (ActionMenuItemView)findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User findUser = userDao.queryBuilder().where(UserDao.Properties.Id.eq(1)).build().unique();
                if(findUser!=null) {
                    findUser.setBirthday(birthday.getText().toString());
                    findUser.setEmail(email.getText().toString());
                    findUser.setGender(gender);
                    findUser.setIntroduce(introduce.getText().toString());
                    findUser.setUsername(name.getText().toString());
                    userDao.update(findUser);
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
            Birthday = birthday.getText().toString();
        }
    };
}
