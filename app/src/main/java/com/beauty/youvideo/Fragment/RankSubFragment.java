package com.beauty.youvideo.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beauty.youvideo.R;

/**
 * Created by bangwen.lei on 2017/7/18.
 */

public class RankSubFragment extends BaseFragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.rank_fragment_sub_fragment_layout, null);
        return rootView;
    }

    public RankSubFragment(String pageTitle, int fragmentId){
        this.pageTigle = pageTitle;
        this.fragmentId = fragmentId;
    }
}
