package com.example.corodinatelayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by wda on 2017/6/7.
 */
public class SelecthotoDetailActivity extends Activity {
    private ImageView imageView;
    private TextView titleView;
    private TextView descriptionView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        setContentView(R.layout.after_selected_recycle_layout_detail_xwk);
        imageView = (ImageView)findViewById(R.id.large_image_item);
        titleView = (TextView) findViewById(R.id.title);
        descriptionView = (TextView) findViewById(R.id.description);
        int drawable = getIntent().getExtras().getInt("src");
        String title_get = getIntent().getExtras().getString("title");
        int description_get = getIntent().getExtras().getInt("description");
        imageView.setImageResource(drawable);
        titleView.setText(title_get);
        descriptionView.setText(description_get);
        imageView.animate().setDuration(1000).withStartAction(new Runnable() {
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
