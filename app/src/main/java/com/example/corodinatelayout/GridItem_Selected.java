package com.example.corodinatelayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class GridItem_Selected extends RelativeLayout implements Checkable {

    private Context mContext;
    private boolean mChecked;
    private ImageView mImgView = null;
    private ImageView mSecletView = null;

    public GridItem_Selected(Context context) {
        this(context, null, 0);
    }

    public GridItem_Selected(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GridItem_Selected(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
        mContext = context;
        LayoutInflater.from(mContext).inflate(R.layout.grid_item_selected, this);
        mImgView = (ImageView) findViewById(R.id.img_view);
        mSecletView = (ImageView) findViewById(R.id.select);
    }

    @Override
    public void setChecked(boolean checked) {
        // TODO Auto-generated method stub
        mChecked = checked;
        setBackgroundDrawable(checked ? getResources().getDrawable(
                R.drawable.background) : null);
        mSecletView.setVisibility(checked ? View.VISIBLE : View.GONE);
    }

    @Override
    public boolean isChecked() {
        // TODO Auto-generated method stub
        return mChecked;
    }

    @Override
    public void toggle() {
        // TODO Auto-generated method stub
        setChecked(!mChecked);
    }

    public void setImgResId(int resId) {
        if (mImgView != null) {
            mImgView.setBackgroundResource(resId);
        }
    }

}
