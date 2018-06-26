package com.idx.reader.tableviewpager;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.idx.reader.R;

import java.util.ArrayList;
import java.util.List;

public class Table1Fragment extends Fragment {
    private TabLayout tabLayout;
    private List<Fragment> childlist;
    private  ViewPager viewPager;
    private MyChildAdapter myChildAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.table1fragment,container, false);
        //实例化
        viewPager = (ViewPager)view.findViewById(R.id.child_view_pager);
        tabLayout = (TabLayout)view.findViewById(R.id.childtablayout);
        //设置布局填充
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //设置固定
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        childlist = new ArrayList<>();
        childlist.add(new Fragment1());
        childlist.add(new Fragment2());
        childlist.add(new Fragment3());
        childlist.add(new Fragment4());
        myChildAdapter = new MyChildAdapter(getChildFragmentManager());
        viewPager.setAdapter(myChildAdapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
    class MyChildAdapter extends FragmentPagerAdapter {

        private String[] mTitles = new String[]{"推荐","口味","排行","分类"};

        public MyChildAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return childlist.get(position);
        }
        @Override
        public int getCount() {
            return childlist.size();
        }
        //ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }
    }
}
