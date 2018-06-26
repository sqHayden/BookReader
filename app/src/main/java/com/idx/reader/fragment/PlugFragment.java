package com.idx.reader.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.idx.reader.R;

/**
 * Created by xieshulan on 17-9-22.
 */

public class PlugFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.plug_fragment, container, false);
    }
}
