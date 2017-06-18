package com.example.corodinatelayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class GridLayout_Selected extends Activity implements MultiChoiceModeListener {

    private GridView mGridView;
    private GridAdapter mGridAdapter;
    private TextView mActionText;
    private static final int MENU_SELECT_ALL = 0;
    private static final int MENU_UNSELECT_ALL = MENU_SELECT_ALL + 1;
    private Map<Integer, Boolean> mSelectMap = new HashMap<Integer, Boolean>();
    private int[] glist = new int[15];

    private int[] mImgIds = new int[] { R.drawable.animal_select, R.drawable.car_select,
            R.drawable.city_select, R.drawable.iphone7_select, R.drawable.movie_select,
            R.drawable.save_select };

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_selected_main);

        mGridView = (GridView) findViewById(R.id.gridview);
        mGridView.setChoiceMode(GridView.CHOICE_MODE_MULTIPLE_MODAL);
        mGridAdapter = new GridAdapter(this);
        mGridView.setAdapter(mGridAdapter);
        mGridView.setMultiChoiceModeListener(this);
    }

    /** Override MultiChoiceModeListener start **/
    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        // TODO Auto-generated method stub
        View v = LayoutInflater.from(this).inflate(R.layout.actionbar_layout_selected,
                null);
        mActionText = (TextView) v.findViewById(R.id.action_text);
        mActionText.setText(formatString(mGridView.getCheckedItemCount()));
        mode.setCustomView(v);
        getMenuInflater().inflate(R.menu.action_menu_selected, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        // TODO Auto-generated method stub
        menu.getItem(MENU_SELECT_ALL).setEnabled(
                mGridView.getCheckedItemCount() != mGridView.getCount());
        return true;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

        Intent intent = new Intent();

        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case R.id.menu_select:
                for (int i = 0; i < mGridView.getCount(); i++) {
                    mGridView.setItemChecked(i, true);
                    mSelectMap.put(i, true);
                }
                break;
            case R.id.menu_unselect:
                for (int i = 0; i < mGridView.getCount(); i++) {
                    mGridView.setItemChecked(i, false);
                    mSelectMap.clear();
                }
                break;
            case R.id.select_update:
                int j = 1;
                for (int i = 0; i < mGridView.getCount(); i++) {
                    if(mSelectMap.get(i) != null) {
                        if (mSelectMap.get(i)) {

                            glist[j] = i+1;
                            System.out.println(glist[j]);
                        }
                        j++;
                    }
                    System.out.println("选择结束1");



                }
                for (int a = 0;a< j;a++ ){
                    System.out.println(glist[a]);
                }
                System.out.println("选择结束");
                intent.putExtra("getlist",glist);
                intent.setClass(GridLayout_Selected.this, SelectPictureShowActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        // TODO Auto-generated method stub
        mGridAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemCheckedStateChanged(ActionMode mode, int position,
                                          long id, boolean checked) {
        // TODO Auto-generated method stub
        mActionText.setText(formatString(mGridView.getCheckedItemCount()));
        mSelectMap.put(position, checked);
        mode.invalidate();
    }

    /** Override MultiChoiceModeListener end **/

    private String formatString(int count) {
        return String.format(getString(R.string.selection), count);
    }

    private class GridAdapter extends BaseAdapter {

        private Context mContext;

        public GridAdapter(Context ctx) {
            mContext = ctx;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return mImgIds.length;
        }

        @Override
        public Integer getItem(int position) {
            // TODO Auto-generated method stub
            return Integer.valueOf(mImgIds[position]);
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            GridItem_Selected item;
            if (convertView == null) {
                item = new GridItem_Selected(mContext);
                item.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
                        LayoutParams.FILL_PARENT));
            } else {
                item = (GridItem_Selected) convertView;
            }
            item.setImgResId(getItem(position));
            item.setChecked(mSelectMap.get(position) == null ? false
                    : mSelectMap.get(position));
            return item;
        }
    }

}