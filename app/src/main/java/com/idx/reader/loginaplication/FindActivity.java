package com.idx.reader.loginaplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.idx.reader.R;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by darkmi on 17-9-21.
 */

public class FindActivity extends Activity {
    private EditText find_phoneNumber;
    private Button find_password;
    private TextView find_icon;
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_password);
        find_password = (Button)findViewById(R.id.find_password);
        findViews();
        //监听找回按钮
        find_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.find_phoneNumber);
                String phoneNumber = find_phoneNumber.getText().toString();
                //判断输入数字的长度，如果不等于11位提示输入号码不正确
                if (phoneNumber.length() == 11) {
                    UserService userService = new UserService(FindActivity.this);
                    //调用UserService的find方法并传入phoneNumber
                    String password = userService.find(phoneNumber);
                    //Log.i("pwd",pwd);
                    //Log.d("phone",phoneNumber);
                    //Log.d("打印",password.toString());
                    List list = new ArrayList();
                    list.add(password);
                    //LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linear2);
                    //判断密码是否为空为空表示没有数据
                    if (password != null) {
//                        for (Object pwd : list) {
//                            TextView textView = (TextView)findViewById(R.id.find_phoneNumber);
//                            textView.setText("您的手机号码是：" + phoneNumber.toString() + "   " + "您的密码是：" + pwd.toString());
//                            textView.setTextSize(20);
//                            //linearLayout.addView(textView);
//                        }
                        String data1 = phoneNumber;
                        String data2 = password;
                        Intent intent = new Intent(FindActivity.this,FindSuccessActivity.class);
                        intent.putExtra("phoneNumber",data1);
                        intent.putExtra("password",data2);
                        startActivity(intent);

                    } else {
                        Toast.makeText(FindActivity.this, "查找失败,请输入正确手机号码！", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(FindActivity.this, "您输入的号码不正确,请重新输入！", Toast.LENGTH_LONG).show();
                    textView.setText("");
                }
            }
        });
        //返回上一层按钮
        find_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    public void findViews() {
        //绑定组件
        find_password = (Button) findViewById(R.id.find_password);
        find_phoneNumber = (EditText) findViewById(R.id.find_phoneNumber);
        find_icon = (TextView) findViewById(R.id.find_icon);
    }
}
