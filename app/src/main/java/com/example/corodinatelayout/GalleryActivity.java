package com.example.corodinatelayout;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by zq on 2017/6/18.
 */

public class GalleryActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_layout);
        ImageView image1=(ImageView)findViewById(R.id.meishi1);
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GalleryActivity.this,ImageLargeActivity2.class);
                intent.putExtra("src",R.drawable.ai1);
                startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(GalleryActivity.this,view,"turn_large1").toBundle());
            }
        });

        ImageView image2=(ImageView)findViewById(R.id.meishi2);
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GalleryActivity.this,ImageLargeActivity2.class);
                intent.putExtra("src",R.drawable.fanchuan);
                startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(GalleryActivity.this,view,"turn_large2").toBundle());
            }
        });

        ImageView image3=(ImageView)findViewById(R.id.tiyu1);
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GalleryActivity.this,ImageLargeActivity2.class);
                intent.putExtra("src",R.drawable.logo);
                startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(GalleryActivity.this,view,"turn_large3").toBundle());
            }
        });

        ImageView image4=(ImageView)findViewById(R.id.tiyu2);
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GalleryActivity.this,ImageLargeActivity2.class);
                intent.putExtra("src",R.drawable.gou);
                startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(GalleryActivity.this,view,"turn_large4").toBundle());
            }
        });

        ImageView image5=(ImageView)findViewById(R.id.fengjing1);
        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GalleryActivity.this,ImageLargeActivity2.class);
                intent.putExtra("src",R.drawable.chahua);
                startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(GalleryActivity.this,view,"turn_large5").toBundle());
            }
        });

        ImageView image6=(ImageView)findViewById(R.id.fengjing2);
        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GalleryActivity.this,ImageLargeActivity2.class);
                intent.putExtra("src",R.drawable.naicha);
                startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(GalleryActivity.this,view,"turn_large6").toBundle());
            }
        });
    }

}