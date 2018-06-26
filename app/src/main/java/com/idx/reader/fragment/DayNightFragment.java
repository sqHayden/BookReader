package com.idx.reader.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.idx.reader.R;

/**
 * Created by xieshulan on 17-10-10.
 */

public class DayNightFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.day_night_fragment, container, false);
    }
//    private int theme = R.style.AppTheme;
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if(savedInstanceState!=null){
//            theme=savedInstanceState.getInt("theme");
//            getActivity().setTheme(theme);
//        }
//    }
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.day_night_fragment, container);
//        Switch s1=(Switch)view.findViewById(R.id.id_daynight_switch);
//        s1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                theme=(theme==R.style.AppTheme)?R.style.NightAppTheme:R.style.AppTheme;
//                getActivity().recreate();
//            }
//        });
//    return  view;
//    }
}