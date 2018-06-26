package com.idx.reader.subscribe;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by steve on 17-10-9.
 */
/*
 * 数据存储到SharedPreferences
 */
public class SharedPreferencesUtils {
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    public SharedPreferencesUtils(Context context,String fileName) {
        sp = context.getSharedPreferences(fileName,Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    //保存list
    public void setList(String tag, List<Subscribe> list){
        if (list==null || list.size()<=0){
            return;
        }
        Gson gson=new Gson();
        String strJson=gson.toJson(list);
        editor.clear();
        editor.putString(tag,strJson);
        editor.commit();
    }

    //获取list
    public List<Subscribe> getList(String tag){
        List<Subscribe> list=new ArrayList<Subscribe>();
        String strJson=sp.getString(tag,null);
        if (strJson==null){
            return list;
        }
        Gson gson=new Gson();
        list=gson.fromJson(strJson,new TypeToken<List<Subscribe>>(){}.getType());
        return list;
    }
    /*
    //保存list
    public <T> void setList(String tag, List<T> list){
        if (list==null || list.size()<=0){
            return;
        }

        Gson gson=new Gson();
        String strJson=gson.toJson(list);
        editor.clear();
        editor.putString(tag,strJson);
        editor.commit();
    }

    //获取list
    public <T> List<T> getList(String tag){
        List<T> list=new ArrayList<T>();
        String strJson=sp.getString(tag,null);
        if (strJson==null){
            return list;
        }
        Gson gson=new Gson();
        list=gson.fromJson(strJson,new TypeToken<List<T>>(){}.getType());
        return list;
    }
    */
}
