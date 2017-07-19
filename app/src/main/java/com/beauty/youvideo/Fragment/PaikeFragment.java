package com.beauty.youvideo.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beauty.youvideo.R;

/**
 * Created by bangwen.lei on 2017/7/17.
 */

public class PaikeFragment extends BaseFragment {

    public PaikeFragment(int fragmentId) {
        this.fragmentId = fragmentId;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_paike, null);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
