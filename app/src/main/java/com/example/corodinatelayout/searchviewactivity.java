package com.example.corodinatelayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class searchviewactivity extends Activity implements SearchView.OnQueryTextListener {


    private SearchView sv;
    private ListView lv;


    private ArrayList<String> list = new ArrayList<String>();
    //自动完成的列表
    private final String[] mStrings = {"Line", "Baby", "Devil", "angel", "tide", "MONKI", "Logo", "wild", "agatha", "yoki"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            // Translucent status bar
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(R.color.colorP);// 通知栏所需颜色
        }


        setContentView(R.layout.searchview);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        lv = (ListView) findViewById(R.id.lv);//设置监听器
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrings));
        lv.setTextFilterEnabled(true);
        sv = (SearchView)

                findViewById(R.id.sv);
        //设置该SearchView默认是否自动缩小为图标
        sv.setIconifiedByDefault(false);
        //为该SearchView组件设置事件监听器
        sv.setOnQueryTextListener(this);
        //设置该SearchView显示搜索按钮
        sv.setSubmitButtonEnabled(true);
        //设置该SearchView内默认显示的提示文本
        sv.setQueryHint("搜索采集、画板、用户");





        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getId()) {
                    case R.id.lv:
                        expressItemClick(2);//position 代表你点的哪一个
                        break;
                }
            }
        });


        TextView textview=(TextView)findViewById(R.id.titl1);
        textview.setOnClickListener(new textClickListener());
    }
    class textClickListener implements View.OnClickListener {

        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(searchviewactivity.this,ViewpageActivity.class);
            startActivity(intent);
        }
    }
        public void expressItemClick(int postion){
            Intent intent = new Intent();
            intent.setClass(searchviewactivity.this,ViewpageActivity.class);
        startActivity(intent);
        finish();//看你需不需要返回当前界面，如果点返回需要返回到当前界面，就不用这个




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_view_test, menu);
        return true;
    }

    //用户输入字符时激发该方法
    @Override
    public boolean onQueryTextChange(String newText) {
        // TODO Auto-generated method stub
        if (TextUtils.isEmpty(newText)) {
            //清楚ListView的过滤
            lv.clearTextFilter();
        } else {
            //使用用户输入的内容对ListView的列表项进行过滤
            lv.setFilterText(newText);

        }
        return true;
    }

    //单击搜索按钮时激发该方法
    @Override
    public boolean onQueryTextSubmit(String query) {
        // TODO Auto-generated method stub
        //实际应用中应该在该方法内执行实际查询
        //此处仅使用Toast显示用户输入的查询内容
        Toast.makeText(this, "您选择的是：" + query, Toast.LENGTH_SHORT).show();
        return true;
    }


}