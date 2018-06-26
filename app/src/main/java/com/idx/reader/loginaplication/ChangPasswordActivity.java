package com.idx.reader.loginaplication;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.idx.reader.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by darkmi on 17-10-10.
 */
public class ChangPasswordActivity extends Activity {
    private SharedPreferences sharePreferences;
    private SharedPreferences.Editor editor;
    private DatabaseHelper databaseHelper;
    private EditText pwd,editText1;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharePreferences = PreferenceManager.getDefaultSharedPreferences(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        //获取从FindSuccessActivity得到的数据
        Intent intent = getIntent();
        final String phone = intent.getStringExtra("phoneNumber");
        textView = (TextView) findViewById(R.id.text_phone);
        //将获取到色电话号码显示到TextView中，并设置字体大小
        textView.setText(phone);
        textView.setTextSize(20);
        //绑定组件
        pwd = (EditText) findViewById(R.id.change_password);
        editText1 = (EditText) findViewById(R.id.change_confirm_password);

        //当输入框失焦时调用checkChangePassword方法判断密码合法性
        pwd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String password = pwd.getText().toString().trim();
                if (!hasFocus){
                    checkChangePassword(password);
                }
            }
        });
        //当输入框失焦时调用confirm方法判断两次输入密码是否相同
        editText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String password = editText1.getText().toString().trim();
                String confirmPassword = editText1.getText().toString().trim();
                if(!hasFocus){
                    confirm(password,confirmPassword);
                }
            }
        });
        Button button = (Button) findViewById(R.id.save_password);
        databaseHelper = new DatabaseHelper(this);
        //监听保存密码按钮
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = pwd.getText().toString().trim();
                String confirmPassword = editText1.getText().toString().trim();
                //当输入框验证都通过时执行更新密码操作
                if (checkChangePassword(password) && confirm(password, confirmPassword) == true){
                    SQLiteDatabase db = databaseHelper.getReadableDatabase();
                    ContentValues contentValues = new ContentValues();
                    // String password = editText.getText().toString();
                    contentValues.put("password", password);
                    editor = sharePreferences.edit();
                    //将电话号码与新密码保存到sharePreferences中
                    editor.putString("phoneNumber", phone);
                    editor.putString("password", password);
                    editor.apply();
                    //通过传递的电话号码更新密码
                    db.update("user", contentValues, "phoneNumber=?", new String[]{phone});
                    Toast.makeText(ChangPasswordActivity.this, "密码变更成功", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(ChangPasswordActivity.this, LoginActivity.class);
                    startActivity(intent1);
                    finish();
                }else {
                    Toast.makeText(ChangPasswordActivity.this, "请输入6-16位数字或字母组成的密码", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    //设置密码规则
    private boolean checkChangePassword(String password) {
        String regularExpression = "^[0-9a-zA-Z]{6,15}$";
        Pattern pattern = Pattern.compile(regularExpression);
        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            pwd.setError(getResources().getString(R.string.wrong_password));
            return false;
        } else {
            return true;
        }


    }
    //判断两次输入的密码是否一样
    private boolean confirm(String password,String confirmPassword){
        if(password.equals(confirmPassword)){
            return true;
        }else {
            Log.i("MIMA",password+"___"+confirmPassword);
            editText1.setError(getResources().getString(R.string.confirm));
            return false;
        }
    }
}