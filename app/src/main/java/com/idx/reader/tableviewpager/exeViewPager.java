package com.idx.reader.tableviewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by shaoqi on 17-9-25.
 */

public class exeViewPager extends ViewPager{
    public exeViewPager(Context context) {
        super(context);
    }
    public exeViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
    }
    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
       return false;
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        return false;
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(item, false);
    }
}

