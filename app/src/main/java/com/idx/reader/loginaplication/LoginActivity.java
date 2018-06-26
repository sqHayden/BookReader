package com.idx.reader.loginaplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.idx.reader.MainActivity;
import com.idx.reader.R;

public class LoginActivity extends AppCompatActivity {
    private EditText login_phoneNumber;
    private EditText login_password;
    private TextView login_register;
    private TextView login_find_password;
    private TextView back;
    private CheckBox login_remember;
    private Button login_button;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //绑定组件
        login_phoneNumber = (EditText) findViewById(R.id.login_phoneNumber);
        login_password = (EditText) findViewById(R.id.login_password);
        login_register = (TextView)findViewById(R.id.login_register);
        login_find_password = (TextView)findViewById(R.id.login_find_password);
        login_remember = (CheckBox)findViewById(R.id.login_remember);
        login_button = (Button) findViewById(R.id.login_button);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        back = (TextView) findViewById(R.id.login_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        final boolean rememberPassword = sharedPreferences.getBoolean("rememberPass",false);
        //判断是否记住密码，是的话就将密码从SharePreferences中取出放到登录输入框中
        if(rememberPassword == true){
            String phoneNumber = sharedPreferences.getString("phoneNumber","");
            String password = sharedPreferences.getString("password","");
            login_phoneNumber.setText(phoneNumber);
            login_password.setText(password);
            login_remember.setChecked(true);
            //Log.d("TAG",phoneNumber+ "_"+password);
            //跳转到登录成功页面
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }else if(rememberPassword == false){
            String phoneNumber = sharedPreferences.getString("phoneNumber","");
            login_phoneNumber.setText(phoneNumber);
            login_remember.setChecked(false);
        }
        //监听登录按钮点击事件
        login_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //将输入框内容转化成字符串
                String phoneNumber = login_phoneNumber.getText().toString();
                String password = login_password.getText().toString();

                Log.d("TAG",phoneNumber+ "_"+password);
                UserService userService = new UserService(LoginActivity.this);
                boolean flag = userService.login(phoneNumber,password);
                Log.v("TAG","flag:"+flag);
                if(flag) {
                    editor = sharedPreferences.edit();
                    //是否记住密码，是的话 将电话号码与密码保存到SharePreferences中，否则只保存电话号码
                    if (login_remember.isChecked() == true) {
                        Log.d("TAG", "111:" + login_remember.isChecked());
                        editor.putBoolean("rememberPass", true);
                        editor.putString("phoneNumber", phoneNumber);
                        editor.putString("password", password);
                    }else if(login_remember.isChecked() == false){
                        editor.putBoolean("rememberPass", false);
                        editor.putString("phoneNumber", phoneNumber);
                    }
                    editor.apply();

                    finish();
                    Log.v("TAG","登录成功");
                    //跳转到登录成功页面
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    //提示登录成功
                    Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_LONG).show();
                    //finish();
               }else{
                    Log.v("TAG","登录失败");
                    Toast.makeText(LoginActivity.this,"登录失败,请输入正确手机号码及密码",Toast.LENGTH_LONG).show();
                }
            }
        });
        //监听注册按钮
        login_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        //监听找回密码按钮
        login_find_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,FindActivity.class);
                startActivity(intent);
            }
        });
    }
}

   /* //验证登录
    private void checkLogin(){
        if (checkLoginName(login_name.getText().toString()) &&
                checkLoginPassword(login_password.getText().toString())){
            Intent intent = new Intent(this,RegisterActivity.class);
            startActivity(intent);
        }
    }
    //设置用户名的格式
    private boolean checkLoginName(String s){
        String regularExpression = "^[1][358][0-9]{9}$";
        Pattern pattern = Pattern.compile(regularExpression);
        Matcher matcher = pattern.matcher(s);

        if (s.length() == 0){
            login_name.setError(getResources().getString(R.string.login_name));
            login_name.requestFocus();
            return false;
        }else{
            if (matcher.matches()){
                return true;
            }else{
                login_name.setError(getResources().getString(R.string.wrong_name));
                login_name.requestFocus();
                return false;
            }
        }
    }
    //设置密码的格式
    private boolean checkLoginPassword(String s){
        String regularExpression = "^[0-9a-zA-Z]{6,16}$";
        Pattern pattern = Pattern.compile(regularExpression);
        Matcher matcher = pattern.matcher(s);

        if (s.length() == 0){
            login_password.setError(getResources().getString(R.string.login_password));
            login_password.requestFocus();
            return false;
        }else{
            if (matcher.matches()){
                return true;
            }else{
                login_password.setError(getResources().getString(R.string.wrong_password));
                login_password.requestFocus();
                return false;
            }
        }
    }*/

