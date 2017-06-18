package com.example.corodinatelayout;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/17.
 */
public class SelectPictureShowActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    public List<SelectpictureBeen> Imagelist;



    private int[] glist = new int[15];


    private int[] imgs ={
            R.drawable.animal, R.drawable.animal, R.drawable.car,
            R.drawable.city, R.drawable.iphone7, R.drawable.movie,
            R.drawable.save
    };
    private String[] titles ={
            "非洲的大象", "非洲的大象","福特2017新款","埃菲尔铁塔","iPhone7介绍","加勒比海盗5：影评","地球环境报告"
    };
    private int[] descriptions= {
            R.string.animal, R.string.animal, R.string.car, R.string.city,
            R.string.iphone7, R.string.movie, R.string.save
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.after_selected_recycle_layout_xwk);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitle("猜你喜欢");
        toolbar.inflateMenu(R.menu.selected_picture_toolbar);

        recyclerView = (RecyclerView)findViewById(R.id.recyler);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        initdata();
        SelectPhotoAdapter selectPhotoAdapter = new SelectPhotoAdapter(Imagelist);

        recyclerView.setAdapter(selectPhotoAdapter);

        glist = getIntent().getIntArrayExtra("getlist");

        for (int a = 0;a< 15;a++ ){
            System.out.println(glist[a]);
        }
        System.out.println("结束+1");


        selectPhotoAdapter.setOnItemClickListener(new SelectPhotoAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(View view, int position) {
                glist = getIntent().getIntArrayExtra("getlist");
                Intent intent = new Intent(getApplicationContext(),SelecthotoDetailActivity.class);
                intent.putExtra("src",imgs[glist[position+1]]);
                System.out.println(position);
                System.out.println("glist"+position+"是"+glist[position]);
                intent.putExtra("title",titles[glist[position+1]]);
                intent.putExtra("description",descriptions[glist[position+1]]);
                startActivity(intent,
                        ActivityOptions.makeSceneTransitionAnimation(
                                SelectPictureShowActivity.this,view,"turn_large").toBundle());

            }
        });




    }
    public void initdata(){

        Imagelist = new ArrayList();



        glist = getIntent().getIntArrayExtra("getlist");

        System.out.println(glist.length);

        int j = 15;
        for (int a = 0;a< j;a++ ){
            System.out.println(glist[a]);
        }
        System.out.println("结束");

        for (int i = 0;i< glist.length;i++){
            if (glist[i] != 0 ) {
                SelectpictureBeen pic = new SelectpictureBeen(imgs[glist[i]], titles[glist[i]],descriptions[glist[i]]);
                Imagelist.add(pic);
            }
        }

    }



}
