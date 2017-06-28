package com.example.corodinatelayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/6/20.
 */

public class DiscoverActivity extends Activity {
    private DrawerLayout drawerLayout;
    private Fruit[] fruits={
            new Fruit("当下视觉",R.drawable.p1),
            new Fruit("饮品摄影",R.drawable.p2)
            ,new Fruit("SomeWhere SomeDay",R.drawable.p3),
            new Fruit("一画一世界",R.drawable.p4)
            ,new Fruit("岁月静好",R.drawable.p5),
            new Fruit("coffee",R.drawable.p6)
            ,new Fruit("不能只让我一个人馋成狗",R.drawable.p7),
            new Fruit("有美人兮",R.drawable.p8)
            ,new Fruit("这个夏天没有迟到",R.drawable.p9),
            new Fruit("Nicokids",R.drawable.p10) ,

            new Fruit("信",R.drawable.p11),
            new Fruit("夏日物语",R.drawable.p12)

            ,new Fruit("故事细腻",R.drawable.p13),
            new Fruit("与棒球有关的青春",R.drawable.p14)
            ,new Fruit("温馨装饰",R.drawable.p15),
            new Fruit("初见惊艳，再见依然",R.drawable.p16)
            ,new Fruit("柚栀",R.drawable.p17),
            new Fruit("长情",R.drawable.p18),
            new Fruit("汽车",R.drawable.p19),
            new Fruit("potatooooo",R.drawable.p20)};

    private List<Fruit> fruitList=new ArrayList<>();

    private FruitAdapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
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


        setContentView(R.layout.discover_main);
        TextView textview=(TextView)findViewById(R.id.item_title);
        textview.setOnClickListener(new textClickListener());
        initFruits();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }
    private void initFruits(){
        fruitList.clear();
        for (int i = 0; i <30 ; i++) {
            Random random=new Random();
            int index=random.nextInt(fruits.length);
            fruitList.add(fruits[index]);
        }
    }
    class textClickListener implements View.OnClickListener {

        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(DiscoverActivity.this,searchviewactivity.class);
            startActivity(intent);
        }
    }







}
