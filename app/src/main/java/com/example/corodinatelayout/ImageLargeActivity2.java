package com.example.corodinatelayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

/**
 * Created by zq on 2017/6/20.
 */

public class ImageLargeActivity2 extends Activity {
    private ImageView imageView;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView imageView6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        setContentView(R.layout.largeimage_layout);
        imageView = (ImageView)findViewById(R.id.large_image_item1);
        imageView2 = (ImageView)findViewById(R.id.large_image_item2);
        imageView3 = (ImageView)findViewById(R.id.large_image_item3);
        imageView4 = (ImageView)findViewById(R.id.large_image_item4);
        imageView5 = (ImageView)findViewById(R.id.large_image_item5);
        imageView6 = (ImageView)findViewById(R.id.large_image_item6);
        int drawable = getIntent().getExtras().getInt("src");
        imageView.setImageResource(drawable);
        imageView.animate().setDuration(1000).withStartAction(new Runnable() {
            @Override
            public void run() {

            }
        }).withEndAction(new Runnable() {
            @Override
            public void run() {

            }
        });

        imageView2.setImageResource(drawable);
        imageView2.animate().setDuration(1000).withStartAction(new Runnable() {
            @Override
            public void run() {

            }
        }).withEndAction(new Runnable() {
            @Override
            public void run() {

            }
        });

        imageView3.setImageResource(drawable);
        imageView3.animate().setDuration(1000).withStartAction(new Runnable() {
            @Override
            public void run() {

            }
        }).withEndAction(new Runnable() {
            @Override
            public void run() {

            }
        });

        imageView4.setImageResource(drawable);
        imageView4.animate().setDuration(1000).withStartAction(new Runnable() {
            @Override
            public void run() {

            }
        }).withEndAction(new Runnable() {
            @Override
            public void run() {

            }
        });

        imageView5.setImageResource(drawable);
        imageView5.animate().setDuration(1000).withStartAction(new Runnable() {
            @Override
            public void run() {

            }
        }).withEndAction(new Runnable() {
            @Override
            public void run() {

            }
        });

        imageView6.setImageResource(drawable);
        imageView6.animate().setDuration(1000).withStartAction(new Runnable() {
            @Override
            public void run() {

            }
        }).withEndAction(new Runnable() {
            @Override
            public void run() {

            }
        });


    }
}
