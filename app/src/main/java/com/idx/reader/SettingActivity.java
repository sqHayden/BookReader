package com.idx.reader;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Switch;

public class SettingActivity extends AppCompatActivity {
    private static Switch s1 = null;
    private static Switch s2 = null;
    private int theme = R.style.AppTheme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sp=getSharedPreferences("app_style",MODE_PRIVATE);
        theme = sp.getInt("theme",R.style.AppTheme);
        setTheme(theme);

        setContentView(R.layout.setting);
        s1 = (Switch) findViewById(R.id.id_daynight_switch);
        s2=(Switch)findViewById(R.id.id_eye_switch) ;
        if(theme==R.style.NightAppTheme){//夜间
            s1.setChecked(true);
        }else if(theme==R.style.EyeAppTheme){//护眼
            s2.setChecked(true);
        }else if(theme==R.style.AllAppTheme){
            s1.setChecked(true);
            s2.setChecked(true);
        }
        s1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((theme == R.style.AppTheme)) {
                    theme = R.style.NightAppTheme;
                    SettingActivity.this.recreate();
                } else if ((theme == R.style.EyeAppTheme)&&(s2.isChecked())) {
                    theme = R.style.AllAppTheme;
                    SettingActivity.this.recreate();
                } else if((theme == R.style.AllAppTheme)&&(s2.isChecked())) {
                    theme = R.style.EyeAppTheme;
                    SettingActivity.this.recreate();
                }
                else {
                    theme = R.style.AppTheme;
                    SettingActivity.this.recreate();
                }
            }
        });
        s2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((theme == R.style.AppTheme)) {
                    theme = R.style.EyeAppTheme;
                    SettingActivity.this.recreate();
                } else if ((theme == R.style.NightAppTheme)&&(s1.isChecked())) {
                    theme = R.style.AllAppTheme;
                    SettingActivity.this.recreate();
                }
                else if((theme == R.style.AllAppTheme)&&(s1.isChecked())) {
                    theme = R.style.NightAppTheme;
                    SettingActivity.this.recreate();
                }
                 else {
                    theme = R.style.AppTheme;
                    SettingActivity.this.recreate();
                }
           }
       });
    }
    @Override
     public  void onSaveInstanceState(Bundle outState){
            super.onSaveInstanceState(outState);
            outState.putInt("theme",theme);
    }
    @Override
    public void  onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        theme=savedInstanceState.getInt("theme");
    }
    @Override
    public void onPause(){
        super.onPause();
        SharedPreferences.Editor editor=getSharedPreferences("app_style",MODE_PRIVATE).edit();
        editor.putInt("theme",theme);
        editor.apply();
    }
}