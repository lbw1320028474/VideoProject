package com.beauty.youvideo.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.beauty.youvideo.Fragment.BaseFragment;

import java.util.List;

/**
 * Created by bangwen.lei on 2017/7/17.
 */

public class HomeFragmentViewPageAdpater extends FragmentPagerAdapter{
    private List<BaseFragment> fragmentList = null;

    public HomeFragmentViewPageAdpater(FragmentManager fm, List<BaseFragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentList.get(position).getPageTigle();
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
