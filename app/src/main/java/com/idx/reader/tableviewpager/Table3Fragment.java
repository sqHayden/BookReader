package com.idx.reader.tableviewpager;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.idx.reader.R;
import com.idx.reader.subscribe.HeaderAndFooterRefreshListView;
import com.idx.reader.subscribe.MyBaseAdapter;
import com.idx.reader.subscribe.MyDatabaseHandler;
import com.idx.reader.subscribe.SharedPreferencesUtils;
import com.idx.reader.subscribe.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class Table3Fragment extends ListFragment implements HeaderAndFooterRefreshListView.OnRefreshListener{
    HeaderAndFooterRefreshListView listView; //ListView用于显示数据
    List<Subscribe> mList = new ArrayList<>();//将数据封装到集合
    List<Subscribe> spList=new ArrayList<>();//SharedPreferences获取数据
    MyBaseAdapter adapter;//数据适配器
    MyDatabaseHandler myDatabaseHandler;//数据库
    //SharedPreferencesUtils utils;//工具类保存刷新后，状态数据
    private int[] images={//图片资源
            R.drawable.zhuxi, R.drawable.muyang,R.drawable.chuzu,R.drawable.ruxue,
            R.drawable.life,R.drawable.rencai,R.drawable.dity,R.drawable.taifeng
    };


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDatabaseHandler=new MyDatabaseHandler(getActivity());

        SharedPreferencesUtils utils=new SharedPreferencesUtils(getActivity(),"data");
        spList=utils.getList("mList");
        if (spList.size()<=0 || spList==null){
            mList=initSubscribeData();//初始化数据来自数据库
        }else {
            mList=spList;
        }
        adapter = new MyBaseAdapter(getActivity(), mList);
        setListAdapter(adapter);


//        //ListView item的点击事件
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(HotActivity.this, "Click item", Toast.LENGTH_SHORT).show();
//            }
//        });
       // ListView item 中的删除按钮的点击事件
        adapter.setOnItemDeleteClickListener(new MyBaseAdapter.onItemDeleteListener() {
            @Override
            public void onDeleteClick(int i) {
                mList.remove(i);
                adapter.notifyDataSetChanged();
                //Toast.makeText(HotActivity.this, i, Toast.LENGTH_SHORT).show();
            }
        });

    }

    //加载布局
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.tablefragment3,container, false);
        listView = (HeaderAndFooterRefreshListView) view.findViewById(android.R.id.list);
        listView.setOnRefreshListener(this);
        return view;
    }

    @Override
    public void onStop() {
        //activity关闭，将数据保存到SharedPreferences
        SharedPreferencesUtils utils=new SharedPreferencesUtils(getActivity(),"data");
        utils.setList("mList",mList);
        super.onStop();
    }

    @Override
    public void onDownPullRefresh() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                SystemClock.sleep(1000);
                for (int i = 0; i < 4; i++) {
                    Subscribe s=mList.get(7);
                    /*Subscribe s=mList.get(7);
                    String title = s.getTitle();
                    int at = title.indexOf("_");
                    if (at != -1) {
                        title = s.getTitle().substring(0, at);
                    }
                    int pos = title.indexOf("?");
                    if (pos != -1) {
                        title = s.getTitle().substring(0, pos);
                    }
                    s.setTitle(title + "_" + (count++));*/
                    mList.add(0,s);
                }
                return null;
            }
            @Override
            protected void onPostExecute(Void result) {
                adapter.notifyDataSetChanged();
                listView.hideHeaderView();
            }
        }.execute(new Void[]{});
    }

    @Override
    public void onLoadingMore() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                SystemClock.sleep(1000);
                for (int i = 0; i < 4; i++) {
                    //Subscribe s=mList.get(i);
                    Subscribe s=mList.get(7-i);
                    /*String title = s.getTitle();
                    int at = title.indexOf("?");
                    if (at != -1) {
                        title = s.getTitle().substring(0, at);
                    }
                    int pos = title.indexOf("_");
                    if (pos != -1) {
                        title = s.getTitle().substring(0, pos);
                    }
                    s.setTitle(title + "?" + sum++);
                    mList.add(s);*/
                    mList.add(s);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {

                adapter.notifyDataSetChanged();
                listView.hideFooterView();// 控制脚布局隐藏
            }
        }.execute(new Void[]{});
    }

    //数据库中读取数据，封装到集合中
    private List<Subscribe> initSubscribeData() {
        List<Subscribe> subscribes=null;
        SQLiteDatabase sqLiteDatabases=myDatabaseHandler.getReadableDatabase();
        Cursor cursor=sqLiteDatabases.query("subscribe",null,null,null,null,null,null);
        if(cursor!=null){
            subscribes=new ArrayList<Subscribe>();
            int i=0;
            while(cursor.moveToNext()){
                Subscribe subscribe=new Subscribe();
                int imageId=cursor.getInt(cursor.getColumnIndex("imageId"));
                //Log.i("imageId",imageId+"");
                //System.out.println(imageId);
                String title=cursor.getString(cursor.getColumnIndex("title"));
                String desc=cursor.getString(cursor.getColumnIndex("desc"));
                String type=cursor.getString(cursor.getColumnIndex("type"));
                String comment=cursor.getString(cursor.getColumnIndex("comment"));
                String time=cursor.getString(cursor.getColumnIndex("time"));
                /*subscribe.setImageId(images[i++]);
                if (i==8){
                    i=0;
                }*/
                subscribe.setImageId(images[imageId]);
                subscribe.setTitle(title);
                subscribe.setDesc(desc);
                subscribe.setType(type);
                subscribe.setComment(comment);
                subscribe.setTime(time);
                subscribes.add(subscribe);
            }
        }
        cursor.close();
        return subscribes;
    }
}
