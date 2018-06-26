package com.idx.reader.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;
import com.idx.reader.R;

/**
 * Created by xieshulan on 17-9-21.
 */

public class TitleFragment extends Fragment {
    private ImageButton mLeftMenu;
    private Toast toast;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.title_fragment,container,false);
        mLeftMenu=(ImageButton)view.findViewById(R.id.id_title_left_igb);
       mLeftMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//点击后退时
                getActivity().finish();
            }
       });
        return view;
    }
}
