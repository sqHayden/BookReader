package com.idx.reader.loginaplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
 * Created by darkmi on 17-9-20.
 */

public class RegisterActivity extends AppCompatActivity {
    EditText register_phoneNumber;
    EditText register_password;
    EditText register_confirm_password;
    TextView register_icon;
    Button register;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findViews();
        //失焦后判断输入是否合法
        register_phoneNumber.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String phoneNumber = register_phoneNumber.getText().toString().trim();
                if (!hasFocus){
                        checkLoginName(phoneNumber);
                }
            }
        });
        register_password.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String password = register_password.getText().toString().trim();
                if (!hasFocus){
                    checkLoginPassword(password);
                }
            }
        });
        register_confirm_password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String password = register_password.getText().toString().trim();
                String confirmPassword = register_confirm_password.getText().toString().trim();
                if(!hasFocus){
                    confirm(password,confirmPassword);
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = register_phoneNumber.getText().toString().trim();
                String password = register_password.getText().toString().trim();
                String confirmPassword = register_confirm_password.getText().toString().trim();
                //判断是所有的输入否已经合法，合法就将数据插入到数据库中，否则提示失败
                if ((checkLoginName(phoneNumber) && checkLoginPassword(password) && confirm(password, confirmPassword)) == true) {
                    Log.i("TAG", phoneNumber + "_" + password);
                    //实例化UserService
                    UserService userService = new UserService(RegisterActivity.this);
                    User user = new User();
                    user.setPhoneNumber(phoneNumber);
                    user.setPassword(password);
                    //调用UserService的register方法
                    userService.register(user);
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(RegisterActivity.this, "注册失败，请填写正确的信息！", Toast.LENGTH_LONG).show();
                }
            }
        });
        //返回到登录页面
        register_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    //设置用户名的格式
    private boolean checkLoginName(String phoneNumber){
        String regularExpression = "^[1][3578][0-9]{9}$";
        Pattern pattern = Pattern.compile(regularExpression);
        Matcher matcher = pattern.matcher(phoneNumber);
        if(!matcher.matches()){
            register_phoneNumber.setError(getResources().getString(R.string.wrong_name));
            return false;
        }else{
            return true;
        }

    }
    //设置密码的格式
    private boolean checkLoginPassword(String password) {
        String regularExpression = "^[0-9a-zA-Z]{6,15}$";
        Pattern pattern = Pattern.compile(regularExpression);
        Matcher matcher = pattern.matcher(password);
        if(!matcher.matches()){
            register_password.setError(getResources().getString(R.string.wrong_password));
            return false;
        }else {
            return true;
        }

    }
    //判断两次输入的密码是否一样
    private boolean confirm(String password,String confirmPassword){
        if(password.equals(confirmPassword)){
            return true;
        }else {
            Log.i("MIMA",password+"___"+confirmPassword);
            register_confirm_password.setError(getResources().getString(R.string.confirm));
            return false;
        }
    }

    private void findViews(){
        //绑定组件
        register_phoneNumber = (EditText)findViewById(R.id.register_number);
        register_password = (EditText)findViewById(R.id.register_password);
        register_icon = (TextView) findViewById(R.id.register_icon);
        register = (Button)findViewById(R.id.register_button);
        register_confirm_password = (EditText)findViewById(R.id.register_confirm_password);

    }
}
