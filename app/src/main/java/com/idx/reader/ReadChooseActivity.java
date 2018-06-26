package com.idx.reader;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ReadChooseActivity extends AppCompatActivity {
    // 默认是日间模式
    private int theme = R.style.AppTheme;
    Button little_button = null;
    Button button = null;
    Button button1,button2,button3,button4,button5,
            button6,button7,button8,button9,button10,
            button11,button12,button13,button14,button15,
            button16,button17,button18,button19,button20,
            button21,button22,button23,button24,button25,
            button26,button27,button28,button29,button30,
            button31,button32,button33,button34 = null;
    private static int state = -1;
    private static Map<Integer,Integer> list = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sp1 = getSharedPreferences("app_style", Context.MODE_PRIVATE);
        theme = sp1.getInt("theme",R.style.AppTheme);
        setTheme(theme);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.read_choose_layout);
//        ActionBar bar = getSupportActionBar();
//        bar.hide();
        ImageView img = (ImageView)findViewById(R.id.back);
        img.setOnClickListener(listener1);
        Log.d("123","456");
        little_button = (Button)findViewById(R.id.little_button);
        little_button.setOnClickListener(little_listener);
        button1 = (Button)findViewById(R.id.buttonA1);
        button1.setOnClickListener(listener);
        Log.d(new Integer(button1.getId()).toString(),"xxxxxxxxxxxx");
        button2 = (Button)findViewById(R.id.buttonA2);
        button2.setOnClickListener(listener);
        button3 = (Button)findViewById(R.id.buttonA3);
        button3.setOnClickListener(listener);
        button4 = (Button)findViewById(R.id.buttonA4);
        button4.setOnClickListener(listener);
        button5 = (Button)findViewById(R.id.buttonA5);
        button5.setOnClickListener(listener);
        button6 = (Button)findViewById(R.id.buttonA6);
        button6.setOnClickListener(listener);
        button7 = (Button)findViewById(R.id.buttonA7);
        button7.setOnClickListener(listener);
        button8 = (Button)findViewById(R.id.buttonA8);
        button8.setOnClickListener(listener);
        button9 = (Button)findViewById(R.id.buttonA9);
        button9.setOnClickListener(listener);
        button10 = (Button)findViewById(R.id.buttonA10);
        button10.setOnClickListener(listener);
        button11 = (Button)findViewById(R.id.buttonB1);
        button11.setOnClickListener(listener);
        button12 = (Button)findViewById(R.id.buttonB2);
        button12.setOnClickListener(listener);
        button13 = (Button)findViewById(R.id.buttonB3);
        button13.setOnClickListener(listener);
        button14 = (Button)findViewById(R.id.buttonB4);
        button14.setOnClickListener(listener);
        button15 = (Button)findViewById(R.id.buttonB5);
        button15.setOnClickListener(listener);
        button16 = (Button)findViewById(R.id.buttonB6);
        button16.setOnClickListener(listener);
        button17 = (Button)findViewById(R.id.buttonB7);
        button17.setOnClickListener(listener);
        button18 = (Button)findViewById(R.id.buttonB8);
        button18.setOnClickListener(listener);
        button19 = (Button)findViewById(R.id.buttonB9);
        button19.setOnClickListener(listener);
        button20 = (Button)findViewById(R.id.buttonB10);
        button20.setOnClickListener(listener);
        button21 = (Button)findViewById(R.id.buttonC1);
        button21.setOnClickListener(listener);
        button22 = (Button)findViewById(R.id.buttonC2);
        button22.setOnClickListener(listener);
        button23 = (Button)findViewById(R.id.buttonC3);
        button23.setOnClickListener(listener);
        button24 = (Button)findViewById(R.id.buttonC4);
        button24.setOnClickListener(listener);
        button25 = (Button)findViewById(R.id.buttonC5);
        button25.setOnClickListener(listener);
        button26 = (Button)findViewById(R.id.buttonC6);
        button26.setOnClickListener(listener);
        button27 = (Button)findViewById(R.id.buttonC7);
        button27.setOnClickListener(listener);
        button28 = (Button)findViewById(R.id.buttonC8);
        button28.setOnClickListener(listener);
        button29 = (Button)findViewById(R.id.buttonC9);
        button29.setOnClickListener(listener);
        button30 = (Button)findViewById(R.id.buttonC10);
        button30.setOnClickListener(listener);
        button31 = (Button)findViewById(R.id.buttonC11);
        button31.setOnClickListener(listener);
        button32 = (Button)findViewById(R.id.buttonC12);
        button32.setOnClickListener(listener);
        button33 = (Button)findViewById(R.id.buttonC13);
        button33.setOnClickListener(listener);
        button34 = (Button)findViewById(R.id.buttonC14);
        button34.setOnClickListener(listener);
        SharedPreferences sp2 = getSharedPreferences("list_style", Context.MODE_PRIVATE);
        //得到保存的串
        String str = sp2.getString("list","");
        if(str.equals("")){//没值自己设定
            list.put(button1.getId(),0);list.put(button2.getId(),0); list.put(button3.getId(),0);
            list.put(button4.getId(),0);list.put(button5.getId(),0); list.put(button6.getId(),0);
            list.put(button7.getId(),0);list.put(button8.getId(),0); list.put(button9.getId(),0);
            list.put(button10.getId(),0);list.put(button11.getId(),0);list.put(button12.getId(),0);
            list.put(button13.getId(),0);list.put(button14.getId(),0); list.put(button15.getId(),0);
            list.put(button16.getId(),0);list.put(button17.getId(),0); list.put(button18.getId(),0);
            list.put(button19.getId(),0);list.put(button20.getId(),0); list.put(button21.getId(),0);
            list.put(button22.getId(),0);list.put(button23.getId(),0); list.put(button24.getId(),0);
            list.put(button25.getId(),0);list.put(button26.getId(),0); list.put(button27.getId(),0);
            list.put(button28.getId(),0);list.put(button29.getId(),0); list.put(button30.getId(),0);
            list.put(button31.getId(),0);list.put(button32.getId(),0); list.put(button33.getId(),0);
            list.put(button34.getId(),0);
        }else{//有值获取list
            Gson gson = new Gson();
            list = gson.fromJson(str,new TypeToken<HashMap<Integer,Integer>>(){}.getType());
            //遍历list
            Iterator<Map.Entry<Integer, Integer>> it = list.entrySet().iterator();
            Log.d("ddd",new Integer(list.size()).toString());
            while (it.hasNext()) {
                Map.Entry<Integer, Integer> entry = it.next();
                //设置颜色
                if(entry.getValue()==1){
                    Log.d(entry.getKey().toString(),entry.getValue().toString());
                    Button bt = (Button)findViewById(entry.getKey());
                    if(theme==R.style.AppTheme){//日间
                        if(bt==null){
                            Log.d("aaa","bbb");
                        }
                        bt.setBackgroundResource(R.drawable.layout2);//变红
                        bt.setTextColor(this.getResources().getColor(R.color.font_day));//字变白
                    }else if(theme==R.style.EyeAppTheme){//护眼
                        bt.setBackgroundResource(R.drawable.layout4);//变浅绿
                        bt.setTextColor(this.getResources().getColor(R.color.font_day));//变白
                    }else if(theme==R.style.AllAppTheme){//综合
                        bt.setBackgroundResource(R.drawable.layout3);//变暗红
                    }else{
                        bt.setBackgroundResource(R.drawable.layout3);//变暗红
                        bt.setTextColor(this.getResources().getColor(R.color.font_night));//变黑
                    }
                }
            }
        }
    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int bid = v.getId();
            if(bid == state || state == -1){
                Log.d(""+bid,"进入第一个");
                state = bid;
                button = (Button)v;
                panduan(state,button,list);
            }else{
                Log.d(""+bid,"进入第二个");
                state = bid;
                button = (Button)v;
                if(list.get(bid)==0){
                    Log.d(""+bid,"变色");
                    if(theme==R.style.AppTheme){//白天
                        button.setBackgroundResource(R.drawable.layout2);//变红
                        button.setTextColor(button.getResources().getColor(R.color.font_day));//变白
                    }else if(theme==R.style.EyeAppTheme) {//护眼
                        button.setBackgroundResource(R.drawable.layout4);//变红
                        button.setTextColor(button.getResources().getColor(R.color.font_day));//变白
                    }else if(theme==R.style.AllAppTheme) {
                        button.setBackgroundResource(R.drawable.layout3);//变暗红
                    } else{
                        button.setBackgroundResource(R.drawable.layout3);//变暗红
                        button.setTextColor(button.getResources().getColor(R.color.font_night));//变黑
                    }
                    list.put(bid,1);
                }else{
                    panduan(state,button,list);
                }
            }
        }
    };

    private View.OnClickListener little_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(ReadChooseActivity.this, "这是阅读帮助", Toast.LENGTH_SHORT).show();
        }
    };

    private View.OnClickListener listener1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

    public void panduan(int bid, Button button, Map<Integer,Integer> list){
        if(theme==R.style.AppTheme) {//白天字体变色
            if ((int) list.get(bid) == 1) {
                Log.d("" + bid, "恢复");
                button.setBackgroundResource(R.drawable.layout);//恢复
                button.setTextColor(this.getResources().getColor(R.color.font_night));//恢复
                list.put(bid, 0);
            } else if ((int) list.get(bid) == 0) {
                Log.d("" + bid, "变色");
                button.setBackgroundResource(R.drawable.layout2);//变红
                button.setTextColor(this.getResources().getColor(R.color.font_day));//变白
                list.put(bid, 1);
            }
        }else if(theme==R.style.EyeAppTheme){//护眼模式变色
            if ((int) list.get(bid) == 1) {
                Log.d("" + bid, "恢复");
                button.setBackgroundResource(R.drawable.layout);//恢复
                button.setTextColor(this.getResources().getColor(R.color.font_night));//恢复
                list.put(bid, 0);
            } else if ((int) list.get(bid) == 0) {
                Log.d("" + bid, "变色");
                button.setBackgroundResource(R.drawable.layout4);//变浅绿
                button.setTextColor(this.getResources().getColor(R.color.font_day));//变白
                list.put(bid, 1);
            }
        }else if(theme==R.style.AllAppTheme){//综合模式变色
            if ((int) list.get(bid) == 1) {
                Log.d("" + bid, "恢复");
                button.setBackgroundResource(R.drawable.layout);//恢复
                button.setTextColor(this.getResources().getColor(R.color.black2));//恢复
                list.put(bid, 0);
            } else if ((int) list.get(bid) == 0) {
                Log.d("" + bid, "变色");
                button.setBackgroundResource(R.drawable.layout3);//变暗红
                list.put(bid, 1);
            }
        } else{
            if ((int) list.get(bid) == 1) {//夜间变色
                Log.d("" + bid, "恢复");
                button.setBackgroundResource(R.drawable.layout);//恢复
                button.setTextColor(this.getResources().getColor(R.color.black1));//恢复
                list.put(bid, 0);
            } else if ((int) list.get(bid) == 0) {
                Log.d("" + bid, "变色");
                button.setBackgroundResource(R.drawable.layout3);//变暗红
                button.setTextColor(this.getResources().getColor(R.color.font_night));//变黑
                list.put(bid, 1);
            }
        }
    }
    //在销毁前保存时刻状态
    @Override
    protected void onPause() {
        super.onPause();
        //保存此时的list
        Gson gson=new Gson();
        SharedPreferences sp1 = getSharedPreferences("theme_style", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor1 = sp1.edit();
        SharedPreferences sp2 = getSharedPreferences("list_style", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor2 = sp2.edit();
        editor1.putInt("theme",theme);
        editor2.putString("list",gson.toJson(list));
        editor1.apply();
        editor2.apply();
    }
}
