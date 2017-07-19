package com.beauty.youvideo.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.beauty.youvideo.Fragment.BaseFragment;

import java.util.List;

/**
 * Created by bangwen.lei on 2017/7/17.
 */

public class MainActivityViewPageAdpater extends FragmentPagerAdapter{
    private List<BaseFragment> fragmentList = null;

    public MainActivityViewPageAdpater(FragmentManager fm, List<BaseFragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }


    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
