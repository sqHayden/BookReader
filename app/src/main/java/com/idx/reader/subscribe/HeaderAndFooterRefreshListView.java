package com.idx.reader.subscribe;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.idx.reader.R;

/**
 * Created by steve on 17-9-22.
 * 继承listView添加头尾布局
 */

public class HeaderAndFooterRefreshListView extends ListView implements AbsListView.OnScrollListener {

    private static final String TAG = "RefreshListView";
    private OnRefreshListener mOnRefershListener;
    private int firstVisibleItemPosition; // 屏幕显示在第一个的item的索引
    private int downY; // 按下时y轴的偏移量
    private View headerView; // 头布局的对象
    private int headerViewHeight; // 头布局的高度
    private ProgressBar mProgressBar; // 头布局的进度条
    private final int DOWN_PULL_REFRESH = 0; // 下拉状态
    private final int RELEASE_REFRESH = 1; // 松开
    private final int REFRESHING = 2; // 刷新中
    private int currentState = DOWN_PULL_REFRESH; // 默认为下拉

    private View footerView; // 脚布局的对象
    private boolean isScrollToBottom; // 是否滑动到底部
    private int footerViewHeight; // 脚布局的高度
    private boolean isLoadingMore = false; // 是否正在加载更多中

    public HeaderAndFooterRefreshListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initHeaderView();
        initFooterView();
        this.setOnScrollListener(this);
    }
    //初始化脚布局
    private void initFooterView() {
        footerView = View.inflate(getContext(), R.layout.refresh_footer, null);
        footerView.measure(0, 0);       //FooterView的高度
        footerViewHeight = footerView.getMeasuredHeight();
        footerView.setPadding(0, -footerViewHeight, 0, 0);
        this.addFooterView(footerView);     // 向ListView的底部添加一个footerView对象
    }

    //初始化头布局
    private void initHeaderView() {
        headerView = View.inflate(getContext(), R.layout.refresh_header, null);
        mProgressBar = (ProgressBar) headerView.findViewById(R.id.pb_header);
        headerView.measure(0, 0);       //headerView的高度
        headerViewHeight = headerView.getMeasuredHeight();
        headerView.setPadding(0, -headerViewHeight, 0, 0);
        this.addHeaderView(headerView);     // 向ListView的顶部添加一个headerView对象
    }

    //触摸事件
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN :
                downY = (int)ev.getY();
                break;
            case MotionEvent.ACTION_MOVE :
                if(currentState==REFRESHING){
                    //如果当前处在刷新状态，则不做处理
                    break;
                }

                int moveY = (int) ev.getY();
                //手指滑动偏移量
                int diff = moveY - downY;

                //int diff = (moveY - downY) / 2;
                //获取新的padding值
                int paddingTop = -headerViewHeight + diff;
                // 如果: -头布局的高度 > paddingTop的值 执行super.onTouchEvent(ev);
                //firstVisibleItemPosition
                if (getFirstVisiblePosition() == 0 && -headerViewHeight < paddingTop) {
                    //向下滑，且处于顶部，设置padding值，该方法实现了顶布局慢慢滑动显现
                    headerView.setPadding(0, paddingTop, 0, 0);

                    if (paddingTop >= 0 && currentState == DOWN_PULL_REFRESH) { // 完全显示了.
                        Log.i(TAG, "松开刷新");
                        currentState = RELEASE_REFRESH;
                        //refreshHeaderView();
                    } else if (paddingTop < 0 && currentState == RELEASE_REFRESH) { // 没有显示完全
                        //进入下拉刷新状态
                        Log.i(TAG, "下拉刷新");
                        currentState = DOWN_PULL_REFRESH;
                        //refreshHeaderView();
                    }
                    // 下拉头布局
                    //headerView.setPadding(0, paddingTop, 0, 0);
                    return true;
                }
                break;
            case MotionEvent.ACTION_UP :
                // 判断当前的状态是松开刷新还是下拉刷新
                if (currentState == RELEASE_REFRESH) {
                    Log.i(TAG, "刷新数据.");
                    headerView.setPadding(0, 0, 0, 0);// 把头布局设置为完全显示状态
                    currentState = REFRESHING;// 进入到正在刷新中状态
                    //refreshHeaderView();
                    if (mOnRefershListener != null) {
                        mOnRefershListener.onDownPullRefresh(); // 调用使用者的监听方法
                    }
                } else if (currentState == DOWN_PULL_REFRESH) {
                    headerView.setPadding(0, -headerViewHeight, 0, 0);// 隐藏头布局
                }
                break;
            default :
                break;
        }
        return super.onTouchEvent(ev);
    }

    //根据currentState刷新头布局的状态
    /*private void refreshHeaderView() {
        switch (currentState) {
            case DOWN_PULL_REFRESH : // 下拉刷新状态
                break;
            case RELEASE_REFRESH : // 松开刷新状态
                break;
            case REFRESHING : // 正在刷新中状态
                break;
            default :
                break;
        }
    }*/

    //当滚动状态改变时回调
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState == SCROLL_STATE_IDLE
                || scrollState == SCROLL_STATE_FLING) {
            if (isScrollToBottom && !isLoadingMore) {// 判断当前是否已经到了底部
                isLoadingMore = true;
                Log.i(TAG, "加载更多数据");
                footerView.setPadding(0, 0, 0, 0);
                this.setSelection(this.getCount());
                if (mOnRefershListener != null) {
                    mOnRefershListener.onLoadingMore();
                }
            }
        }
    }

    //  滚动时调用
    //  firstVisibleItem 当前屏幕显示在顶部的item的position
    //  visibleItemCount 当前屏幕显示了多少个条目的总数
    //  totalItemCount ListView的总条目的总数
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
        firstVisibleItemPosition = firstVisibleItem;
        if (getLastVisiblePosition() == (totalItemCount - 1)) {
            isScrollToBottom = true;
        } else {
            isScrollToBottom = false;
        }
    }

    //设置刷新监听事件
    public void setOnRefreshListener(OnRefreshListener listener) {
        mOnRefershListener = listener;
    }

    //隐藏头布局
    public void hideHeaderView() {
        headerView.setPadding(0, -headerViewHeight, 0, 0);
        mProgressBar.setVisibility(View.VISIBLE);
        currentState = DOWN_PULL_REFRESH;
    }

    //隐藏脚布局
    public void hideFooterView() {
        footerView.setPadding(0, -footerViewHeight, 0, 0);
        isLoadingMore = false;
    }

    public interface OnRefreshListener {

        void onDownPullRefresh();//下拉刷新
        void onLoadingMore();//上拉加载更多
    }
}

