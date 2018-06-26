package com.idx.reader.loginaplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.idx.reader.R;

/**
 * Created by darkmi on 17-10-10.
 */
public class FindSuccessActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_success);
        //获得从FindActivity传递过来的数据
        Intent intent = getIntent();
        final String data1 = intent.getStringExtra("phoneNumber");
        String data2 = intent.getStringExtra("password");
        //绑定组件
        TextView textView1 = (TextView) findViewById(R.id.find_phoneNumber_success);
        TextView textView2 = (TextView) findViewById(R.id.find_password_success);
        //将数据放入到TextView中显示
        textView1.setText("手机号码："+data1);
        textView1.setTextSize(20);
        textView2.setText("您的密码："+data2);
        textView2.setTextSize(20);
        //绑定组件
        Button button1 = (Button) findViewById(R.id.return_login);
        Button button2 = (Button) findViewById(R.id.modify_password);
        //点击返回登录按钮事件
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(FindSuccessActivity.this,LoginActivity.class);
                startActivity(intent1);
            }
        });
        //点击修改密码按钮事件，并将电话号码传递到ChangPasswordActivity
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(FindSuccessActivity.this,ChangPasswordActivity.class);
                intent2.putExtra("phoneNumber",data1);
                startActivity(intent2);
            }
        });

    }
}
