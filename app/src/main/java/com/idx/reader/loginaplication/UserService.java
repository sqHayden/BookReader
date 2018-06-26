package com.idx.reader.loginaplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by darkmi on 17-9-20.
 */

public class UserService {
    private DatabaseHelper databaseHelper;
    public UserService(Context context){
        databaseHelper = new DatabaseHelper(context);
    }
    //登录
    public  boolean login(String phoneNumber,String password){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
        String sql = "select * from user where phoneNumber=? and password=?";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, new String[]{phoneNumber,password});
        if (cursor.moveToFirst() == true){
            sqLiteDatabase.close();
            cursor.close();
            return true;
        }else{
            return false;
        }
    }
    //注册
    public boolean register(User user){

        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
        String sql = "insert into user(phoneNumber,password) values(?,?)";
        Object object[] = {user.getPhoneNumber(),user.getPassword()};
        sqLiteDatabase.execSQL(sql,object);
        sqLiteDatabase.close();
        return true;
    }
    //找回密码
    public String find(String phoneNumber){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
        String sql = "select password from user where phoneNumber=?";
        Cursor cursor = sqLiteDatabase.rawQuery(sql,new String[]{phoneNumber.toString()});
        if(cursor.moveToNext()){
            //String phone = cursor.getString(cursor.getColumnIndex("phoneNumber"));
            String pwd = cursor.getString(cursor.getColumnIndex("password"));
            //Log.d("phoneNumber",phone);
            //Log.d("password",pwd);
            return pwd;
        }
        sqLiteDatabase.close();
        cursor.close();
        return null;
    }
//        //找回密码
//        List list = new ArrayList();
//        DatabaseHelper databaseHelper = new DatabaseHelper(this);
//        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
//        //String sql = "select password from user where phoneNumber=?";
//        Cursor cursor = sqLiteDatabase.query(null, null, null, null, null, null, null);
//        while (cursor.moveToNext()) {
//            String phoneNumber = cursor.getString(0);
//            String password = cursor.getString(1);
//
//            Object user = new User(phoneNumber, password);
//            list.add(user);
//        }
//        for (Object user : list){
//            EditText editText = (EditText)findViewById(R.id.find_success_phone);
//            EditText editText = (EditText)findViewById(R.id.find_success_password);
//            editText1.setText(user.toString());
//
//        }

}
