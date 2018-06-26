package com.idx.reader.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.idx.reader.R;
import com.idx.reader.SecretActivity;

/**
 * Created by xieshulan on 17-9-21.
 */

public class SecretFragment extends Fragment {
    private TextView textView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.secret_fragment,container,false);
        textView=(TextView)view.findViewById(R.id.id_secret_tv);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), SecretActivity.class);
                startActivity(intent);
            }
//                toast=Toast.makeText(getActivity(),"隐私和提醒设置",Toast.LENGTH_LONG);
//                toast.setGravity(Gravity.CENTER, 0, 0);
//               toast.show();}
        });
        return view;
    }
}