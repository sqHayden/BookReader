package com.idx.reader.loginaplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by darkmi on 17-9-20.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    static String name = "user.db";
    static int dbVersion = 1;
    public DatabaseHelper(Context context){
        super(context,name,null,dbVersion);
    }
    //创建数据库表
    public  void onCreate(SQLiteDatabase database){
        String sql = "create table user(id integer primary key autoincrement," +
                "password varchar(20),phoneNumber varchar(20))";
        database.execSQL(sql);
    }
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion){

    }
}
