package com.example.corodinatelayout;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Administrator on 2017/5/17.
 */
public class PictureDescriptionActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    public List<pictureBeen> Imagelist;
    private ImageView imageView;
    private int[] imgs ={
         R.drawable.flower1,R.drawable.flower5,R.drawable.flower5,R.drawable.flower5,R.drawable.flower1,R.drawable.flower5
            ,R.drawable.flower1,R.drawable.flower1,R.drawable.flower1,R.drawable.flower5,R.drawable.flower1,R.drawable.flower5
            ,R.drawable.flower1,R.drawable.flower5,R.drawable.flower1,
    };
    private String[] titles ={
            "春雪","夏雨","秋菊","冬梅","玫瑰","晓月","如花","燕雀","青瓷","浮萍",
            "翡翠","红缨","踏雪","彩石","霓凰"
    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.recycle_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitle("图片预览");
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorTitle));

        toolbar.inflateMenu(R.menu.picture_toolbar);

        toolbar.setNavigationIcon(R.drawable.turn_back);


        recyclerView = (RecyclerView)findViewById(R.id.recyler);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        initdata();
        WdaAdapter wdaAdapter = new WdaAdapter(Imagelist);

        recyclerView.setAdapter(wdaAdapter);
        wdaAdapter.setOnItemClickListener(new WdaAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getApplicationContext(),ImageLargeActivity.class);
                intent.putExtra("src",imgs[position]);
                startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(PictureDescriptionActivity.this,view,"turn_large").toBundle());

            }
        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
//    public void share(View view){
//
//        startActivity(intent,
//                ActivityOptions.makeSceneTransitionAnimation(this,view,"share").toBundle());
//    }
    public void initdata(){
        Imagelist = new ArrayList();
        for(int i = 0;i< 15;i++){
            pictureBeen pic = new pictureBeen(imgs[i],titles[i]);

            Imagelist.add(pic);
        }
    }

}
