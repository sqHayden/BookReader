package com.idx.reader.tableviewpager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.idx.reader.R;

import java.io.InputStream;
/**
 * Created by shaoqi on 17-9-25.
 */

public class Fragment2 extends Fragment {
    private static Bitmap bitmap = null;
    private ImageView img;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragmentlayout2,container, false);
        img = (ImageView) view.findViewById(R.id.view4_id);
        img.setImageBitmap(readBitMap(getActivity(),R.raw.view4));
        System.gc();
        return view;
    }

//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        if (bitmap != null && !bitmap.isRecycled()) {
//            bitmap.recycle();
//            bitmap=null;
//        }
//        img.setBackgroundResource(0);
//        System.gc();
//    }

    @Override
    public void onDestroyView() {
        Log.d("sadsadsadsa","sdfdsfdsfdsfdsf");
        super.onDestroyView();
        unbindDrawables(view);
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
            bitmap=null;
        }
        System.gc();
    }

    public static Bitmap readBitMap(Context context, int resId){
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        //获取资源图片
        InputStream is = context.getResources().openRawResource(resId);
        bitmap = BitmapFactory.decodeStream(is,null,opt);
        return bitmap;
    }

    private void unbindDrawables(View view)
    {
        if (view.getBackground() != null)
        {
            view.getBackground().setCallback(null);
        }
        if (view instanceof ViewGroup && !(view instanceof AdapterView))
        {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++)
            {
                unbindDrawables(((ViewGroup) view).getChildAt(i));
            }
            ((ViewGroup) view).removeAllViews();
            Log.d("垃圾被回收","++++++++++++++");
        }
    }
}