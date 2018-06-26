package com.idx.reader;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.idx.reader.loginaplication.LoginActivity;
import com.idx.reader.tableviewpager.Table1Fragment;
import com.idx.reader.tableviewpager.Table2Fragment;
import com.idx.reader.tableviewpager.Table3Fragment;
import com.idx.reader.tableviewpager.exeViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // 默认是日间模式
    private int theme = R.style.AppTheme;
    private ListView mLvLeftMenu;
    private DrawerLayout mDrawerLayout;
    private Button day_night;

    private TabLayout tabLayout;
    private exeViewPager viewPager;
    private List<Fragment> list;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sp = getSharedPreferences("app_style",Context.MODE_PRIVATE);
        theme = sp.getInt("theme",R.style.AppTheme);
        Log.d("theme:",""+theme);
        setTheme(theme);
        //显示布局
        setContentView(R.layout.activity_main);

        //实例化
        viewPager = (exeViewPager) findViewById(R.id.view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        //页面，数据源
        list = new ArrayList<>();
        list.add(new Table1Fragment());
        list.add(new Table2Fragment());
        list.add(new Table3Fragment());
        //ViewPager的适配器
        adapter = new MyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        //设置布局填充
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //设置固定
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //绑定
        tabLayout.setupWithViewPager(viewPager);

        //获得DrawerLayout组件
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //获得ListView组件
        mLvLeftMenu = (ListView) findViewById(R.id.id_lv_left_menu);
        day_night = (Button)findViewById(R.id.day_night);
        if(theme==R.style.AppTheme){
            day_night.setText("夜间");
        }else{
            day_night.setText("日间");
        }
        //获得ToolBar组件
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //改变ToolBar名称
        toolbar.setTitle("网易云阅读");
        //绑定ToolBar
        setSupportActionBar(toolbar);
        //将ActionBar的图标与DrawerLayout关联起来，用以监听其图标点击展开事件
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        //设置点击图片
        toolbar.setNavigationIcon(R.drawable.hill2);
        setUpDrawer();
        Button setting = (Button)findViewById(R.id.setting);
        setting.setOnClickListener(listener1);
        day_night.setOnClickListener(listener2);
    }

    private void setUpDrawer() {
        Log.d("aa:", "bb");
        //刷新加载
        LayoutInflater inflater = LayoutInflater.from(this);
        //设置菜单
        View v = inflater.inflate(R.layout.nav_header_main, null);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent3);
            }
        });
        TextView tt = (TextView)v.findViewById(R.id.tv);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String phoneNumber = sharedPreferences.getString("phoneNumber","");
        tt.setText(phoneNumber);
        mLvLeftMenu.addHeaderView(v);
        mLvLeftMenu.setAdapter(new MenuItemAdapter(this));
        mLvLeftMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 7) {
                    Intent intent1 = new Intent(MainActivity.this, ReadChooseActivity.class);
                    startActivity(intent1);
                } else {
                    Toast.makeText(MainActivity.this, "我是第 " + i +"个item点击事件", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    //监听设置按钮
    private View.OnClickListener listener1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent2 = new Intent(MainActivity.this, SettingActivity.class);
            startActivity(intent2);
        }
    };

    //监听日夜切换
    private View.OnClickListener listener2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(theme==R.style.AppTheme){
                theme = R.style.NightAppTheme;
            }else{
                theme = R.style.AppTheme;
            }
            SharedPreferences sp = getSharedPreferences("app_style", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putInt("theme",theme);
            editor.apply();
            MainActivity.this.recreate();
        }
    };

    //在销毁前保存时刻状态
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sp = getSharedPreferences("app_style", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("theme",theme);
        editor.apply();
    }

    @Override
    protected void onRestart() {//设置主题
        super.onRestart();
        SharedPreferences sp = getSharedPreferences("app_style",Context.MODE_PRIVATE);
        theme = sp.getInt("theme",R.style.AppTheme);
        Log.d("theme:",""+theme);
        MainActivity.this.recreate();
    }

    class MyAdapter extends FragmentPagerAdapter {

        private String[] mTitles = new String[]{"书城","书架","订阅"};

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }
        @Override
        public int getCount() {
            return list.size();
        }
        //ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }
    }
}
