package com.idx.reader.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SeekBar;
import com.idx.reader.R;

/**
 * Created by xieshulan on 17-9-22.
 */

public  class ScreenLightFragment extends Fragment {
    private SeekBar seekbar;
    private Context context;
    private static int progresses = 250;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sp= getActivity().getSharedPreferences("progress_value",Context.MODE_PRIVATE);
        progresses =  sp.getInt("progress",250);
        if(progresses!=250){//设置保存的屏幕亮度
           changeAppBrightness(progresses);
        }
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.screen_light_fragment,container,false);
        seekbar=(SeekBar)view.findViewById(R.id.seekBar);
        seekbar.setMax(255);
        seekbar.setProgress(progresses);
        initEvent();
        return view;
    }
    private void initEvent(){
        seekbar.setOnSeekBarChangeListener(new MyOnSeekBarChangeListener());
    }
    public int getSystemBrightness(){
        int systemBrightness=0;
        try{
            systemBrightness= Settings.System.getInt(getActivity().getContentResolver(),
                    Settings.System.SCREEN_BRIGHTNESS);
        }catch (Settings.SettingNotFoundException e){
            e.printStackTrace();
        }
        return systemBrightness;
    }
//    public void setSysScreenBrightness(int brightness) {
//        try {
//            ContentResolver resolver = context.getContentResolver();
//            Uri uri = Settings.System
//                    .getUriFor(Settings.System.SCREEN_BRIGHTNESS);
//            Settings.System.putInt(resolver, Settings.System.SCREEN_BRIGHTNESS,
//                    brightness);
//            resolver.notifyChange(uri, null);
//        } catch (Exception e) {
//
//        }
//    }
    class  MyOnSeekBarChangeListener implements SeekBar.OnSeekBarChangeListener{
        @Override
        public void onProgressChanged(SeekBar seekBar,int progress,boolean fromUser){
            progresses = progress;
            changeAppBrightness(progress);
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar){
        }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar){
        }
    }
    public void changeAppBrightness(int brightness){
        Window window=this.getActivity().getWindow();
        WindowManager.LayoutParams lp=window.getAttributes();
        if(brightness==-1){
            lp.screenBrightness=WindowManager.LayoutParams.BRIGHTNESS_OVERRIDE_NONE;
        }else{
            lp.screenBrightness=(brightness<=0?1:brightness)/255f;
        }
        window.setAttributes(lp);
    }
//    @Override
//    public void onDestroy(){
//        SharedPreferences.Editor editor=getActivity().getSharedPreferences("data", Context.MODE_PRIVATE).edit();
//        editor.putString("brightness","progress");
//        editor.apply();
//    }
    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences.Editor editor=getActivity().getSharedPreferences("progress_value",Context.MODE_PRIVATE).edit();
        editor.putInt("progress",progresses);
        editor.apply();
    }
}