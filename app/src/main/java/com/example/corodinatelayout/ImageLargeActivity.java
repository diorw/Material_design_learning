package com.example.corodinatelayout;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.view.Window;
import android.transition.Slide;
import android.widget.ImageView;

/**
 * Created by wda on 2017/6/7.
 */
public class ImageLargeActivity extends Activity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        setContentView(R.layout.imageitem_large);
        imageView = (ImageView)findViewById(R.id.large_image_item);
        int drawable = getIntent().getExtras().getInt("src");
        imageView.setImageResource(drawable);
        imageView.animate().alpha(1).setDuration(1000).withStartAction(new Runnable() {
            @Override
            public void run() {

            }
        }).withEndAction(new Runnable() {
            @Override
            public void run() {

            }
        });
        imageView.setLongClickable();
    }
}
