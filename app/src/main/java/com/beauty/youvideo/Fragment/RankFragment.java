package com.beauty.youvideo.Fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beauty.youvideo.R;
import com.beauty.youvideo.Adapter.HomeFragmentViewPageAdpater;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bangwen.lei on 2017/7/17.
 */

public class RankFragment extends BaseFragment {
    private TabLayout rankTabLayout = null;

    public RankFragment(int fragmentId) {
        this.fragmentId = fragmentId;
    }

    private ViewPager subFragmentViewPage = null;
    private List<BaseFragment> sunFragmentList = null;
    private HomeFragmentViewPageAdpater pageAdpater = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_rank, null);
        initView(rootView, inflater);
        setActionBar(rootView, rankTabLayout);
        setActionBarBg(R.drawable.unified_action_bar_bg);
        setSubFragment();
        return rootView;
    }

    private String getStringById(int resourseId) {
        return getActivity().getResources().getString(resourseId);
    }

    private void setSubFragment() {
        rankTabLayout.setSelectedTabIndicatorColor(Color.WHITE);
        rankTabLayout.setTabTextColors(this.getResources().getColor(
                R.color.color_low_whilte), Color.WHITE);
        rankTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        sunFragmentList = new ArrayList<BaseFragment>();
        sunFragmentList.add(new RankSubFragment(getStringById(R.string.home_fragment_tabtext_allRank), 0));
        sunFragmentList.add(new RankSubFragment(getStringById(R.string.home_fragment_tabtext_recreation), 1));
        sunFragmentList.add(new RankSubFragment(getStringById(R.string.home_fragment_tabtext_society), 2));
        sunFragmentList.add(new RankSubFragment(getStringById(R.string.home_fragment_tabtext_cate), 3));
        sunFragmentList.add(new RankSubFragment(getStringById(R.string.home_fragment_tabtext_fun), 4));
        sunFragmentList.add(new RankSubFragment(getStringById(R.string.home_fragment_tabtext_world), 5));
        sunFragmentList.add(new RankSubFragment(getStringById(R.string.home_fragment_tabtext_technology), 6));
        sunFragmentList.add(new RankSubFragment(getStringById(R.string.home_fragment_tabtext_sports), 7));
        sunFragmentList.add(new RankSubFragment(getStringById(R.string.home_fragment_tabtext_treasure), 8));
        sunFragmentList.add(new RankSubFragment(getStringById(R.string.home_fragment_tabtext_car), 9));
        sunFragmentList.add(new RankSubFragment(getStringById(R.string.home_fragment_tabtext_knowledge), 10));
        sunFragmentList.add(new RankSubFragment(getStringById(R.string.home_fragment_tabtext_live), 11));
        sunFragmentList.add(new RankSubFragment(getStringById(R.string.home_fragment_tabtext_weird), 12));
        pageAdpater = new HomeFragmentViewPageAdpater(getActivity().getSupportFragmentManager(), sunFragmentList);
        rankTabLayout.setupWithViewPager(subFragmentViewPage);
        subFragmentViewPage.setAdapter(pageAdpater);
    }

/*    private void setTabViewTab() {
        homeTabLayout.addTab(homeTabLayout.newTab().setText(R.string.home_fragment_tabtext_recommend));
        homeTabLayout.addTab(homeTabLayout.newTab().setText(R.string.home_fragment_tabtext_recreation));
        homeTabLayout.addTab(homeTabLayout.newTab().setText(R.string.home_fragment_tabtext_society));
        homeTabLayout.addTab(homeTabLayout.newTab().setText(R.string.home_fragment_tabtext_cate));
        homeTabLayout.addTab(homeTabLayout.newTab().setText(R.string.home_fragment_tabtext_fun));
        homeTabLayout.addTab(homeTabLayout.newTab().setText(R.string.home_fragment_tabtext_world));
        homeTabLayout.addTab(homeTabLayout.newTab().setText(R.string.home_fragment_tabtext_technology));
        homeTabLayout.addTab(homeTabLayout.newTab().setText(R.string.home_fragment_tabtext_sports));
        homeTabLayout.addTab(homeTabLayout.newTab().setText(R.string.home_fragment_tabtext_treasure));
        homeTabLayout.addTab(homeTabLayout.newTab().setText(R.string.home_fragment_tabtext_car));
        homeTabLayout.addTab(homeTabLayout.newTab().setText(R.string.home_fragment_tabtext_knowledge));
        homeTabLayout.addTab(homeTabLayout.newTab().setText(R.string.home_fragment_tabtext_live));
        homeTabLayout.addTab(homeTabLayout.newTab().setText(R.string.home_fragment_tabtext_weird));
    }*/

    private void initView(View rootView, LayoutInflater inflater) {
        rankTabLayout = (TabLayout) inflater.inflate(R.layout.home_fragment_action_bar_layout, null);
        subFragmentViewPage = (ViewPager) rootView.findViewById(R.id.rank_fragment_viewPage);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
