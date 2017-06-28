package com.example.corodinatelayout;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {




    ViewPager mViewPager;
    View v;
    private CardView cardView;
    private List<String> mTitleList = new ArrayList<>();
    private List<View> mViewList = new ArrayList<>();
    private TabLayout mTabLayout;
    private LayoutInflater mInflater;
    private View view1, view2, view3, view4, view5;
    private RecyclerView recyclerView;
    private ImageView welcomeImg = null;
    private LinearLayoutManager mLayoutManager;
    private CoordinatorLayout co;
    private ImageButton heart;
    private boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mInflater = LayoutInflater.from(this);
        setupViewPager();
     //   FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("UNDO", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//
//                            }
//                        }).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

       // recyclerView=(RecyclerView)findViewById(R.id.grid_recycler);

//        mLayoutManager=new GridLayoutManager(MainActivity.this,3,GridLayoutManager.VERTICAL,false);
//        recyclerView.setLayoutManager(mLayoutManager);
//        meizis.get(0).setUrl("http://huaban.com/pins/1066111168/");
//        meizis.get(1).setUrl("http://huaban.com/pins/1066113127/");
//        mAdapter = new GridAdapter(MainActivity.this,meizis);
//        recyclerView.setAdapter(mAdapter);

    }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_discover) {
            // Handle the camera action
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,DiscoverActivity.class);
            startActivity(intent);


        } else if (id == R.id.nav_hottest) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,FoldMainActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_classification) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,GridLayout_Selected.class);
            startActivity(intent);

        } else if (id == R.id.nav_dress) {

            Intent intent = new Intent();
            intent.setClass(MainActivity.this,ProfileActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_Collection) {

        }else if (id == R.id.nav_setup) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,SettingActivity.class);
            startActivity(intent);
        }else if (id == R.id.nav_about) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void setupViewPager(){
        //加载各个页面
        TabLayout tab=(TabLayout)findViewById(R.id.tabs);
        view1 = mInflater.inflate(R.layout.content_main,null);
        view2 = mInflater.inflate(R.layout.gallery_layout,null);
        view3 = mInflater.inflate(R.layout.content_main,null);
        //把页面统一放入一个list中,后统一设置
        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);
        //设置每个tab标题
        mTitleList.add("我的关注");
        mTitleList.add("为您推荐");
        mTitleList.add("优质画板");

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(0)));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(2)));
        MyPagerAdapter mAdapter = new MyPagerAdapter(mViewList);
        mViewPager.setAdapter(mAdapter);//给ViewPager设置适配器
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
        mTabLayout.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器

    }
    //ViewPager适配器
    class MyPagerAdapter extends PagerAdapter {
        private List<View> mViewList;

        public MyPagerAdapter(List<View> mViewList) {
            this.mViewList = mViewList;
        }

        @Override
        public int getCount() {
            return mViewList.size();//页卡数
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;//官方推荐写法
        }

        @Override
        public Object instantiateItem(final ViewGroup container, int position) {

            v= new View(container.getContext());
            LayoutInflater inflater = (LayoutInflater)container.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            int resId = 0;
            switch (position){
                case 0:
                    container.addView(mViewList.get(0));
                    return mViewList.get(0);

                case 1:
                    container.addView(mViewList.get(1));
                    return mViewList.get(1);

                case 2:
                    resId = R.layout.content_main;
                    v=inflater.inflate(R.layout.content_main,null,false);
                    heart = (ImageButton)v.findViewById(R.id.po_image0);
                    cardView = (CardView)v.findViewById(R.id.cardview);
                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent();
                            intent.setClass(MainActivity.this,PictureDescriptionActivity.class);
                            startActivity(intent);
                        }
                    });
                    if(heart==null){
                        Log.d("MainActivity", "instantiateItem: null_________________");
                    }
                        heart.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if(flag) {
                                    heart.setImageDrawable(getResources().getDrawable(R.drawable.pressed_heart));
                                    Toast.makeText(container.getContext(),"收藏成功",Toast.LENGTH_SHORT).show();
                                    flag = false;
                                }else{
                                    heart.setImageDrawable(getResources().getDrawable(R.drawable.heart));
                                    Toast.makeText(container.getContext(),"取消收藏",Toast.LENGTH_SHORT).show();
                                    flag = true;
                                }
                            }
                        });


                    break;
            }

            ((ViewPager)container).addView(v,0);
          //  container.addView(mViewList.get(position));//添加页卡
           // return mViewList.get(position);
            return v;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViewList.get(position));//删除页卡
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleList.get(position);//页卡标题
        }

    }




}
