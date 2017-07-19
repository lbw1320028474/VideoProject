package com.beauty.youvideo.Activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.beauty.youvideo.R;
import com.beauty.youvideo.Adapter.MainActivityViewPageAdpater;
import com.beauty.youvideo.Fragment.BaseFragment;
import com.beauty.youvideo.Fragment.HomeFragment;
import com.beauty.youvideo.Fragment.MyFragment;
import com.beauty.youvideo.Fragment.PaikeFragment;
import com.beauty.youvideo.Fragment.RankFragment;
import com.beauty.youvideo.Fragment.ReleaseFragment;
import com.beauty.youvideo.Widget.MyViewPage;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout homeButtonView = null;
    private LinearLayout rankButtonView = null;
    private LinearLayout releaseButtonView = null;
    private LinearLayout paikeButtonView = null;
    private LinearLayout myButtonView = null;
    private MyViewPage fragmentContainer = null;

    private List<BaseFragment> fragmentList = null;
    private List<ImageView> bottomImageList = null;
    private List<TextView> bottomTextList = null;

    private MainActivityViewPageAdpater activityViewPageAdpater = null;

    private static final int FRAGMENT_INDEX_00 = 0;
    private static final int FRAGMENT_INDEX_01 = 1;
    private static final int FRAGMENT_INDEX_02 = 2;
    private static final int FRAGMENT_INDEX_03 = 3;
    private static final int FRAGMENT_INDEX_04 = 4;

    private BaseFragment nowShowFragment = null;

    private ImageView homeBottomImage = null;
    private ImageView rankBottomImage = null;
    private ImageView releaseBottomImage = null;
    private ImageView paikeBottomImage = null;
    private ImageView myBottomImage = null;

    private TextView homeBottomText = null;
    private TextView rankBottomText = null;
    private TextView releaseBottomText = null;
    private TextView paikeBottomText = null;
    private TextView myBottomText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            // Translucent status bar
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_main);
        initView();
        initFragment();
    }

    private void initFragment() {
        fragmentList = new ArrayList<BaseFragment>();
        fragmentList.add(new HomeFragment(0));
        fragmentList.add(new RankFragment(1));
        fragmentList.add(new ReleaseFragment(2));
        fragmentList.add(new PaikeFragment(3));
        fragmentList.add(new MyFragment(4));

        addImageViewToList();
        addTextViewToList();

        activityViewPageAdpater = new MainActivityViewPageAdpater(getSupportFragmentManager(), fragmentList);
        fragmentContainer.setOffscreenPageLimit(5);
        fragmentContainer.setCanScroll(false);
        fragmentContainer.setAdapter(activityViewPageAdpater);
        showFragmentById(FRAGMENT_INDEX_00);
    }

    private void addTextViewToList() {
        bottomTextList = new ArrayList<TextView>();
        bottomTextList.add(homeBottomText);
        bottomTextList.add(rankBottomText);
        bottomTextList.add(releaseBottomText);
        bottomTextList.add(paikeBottomText);
        bottomTextList.add(myBottomText);
    }

    private void addImageViewToList() {
        bottomImageList = new ArrayList<ImageView>();
        bottomImageList.add(homeBottomImage);
        bottomImageList.add(rankBottomImage);
        bottomImageList.add(releaseBottomImage);
        bottomImageList.add(paikeBottomImage);
        bottomImageList.add(myBottomImage);

    }

    private void initView() {
        homeButtonView = (LinearLayout)this.findViewById(R.id.main_activity_bottom_home_button_layout);
        rankButtonView = (LinearLayout)this.findViewById(R.id.main_activity_bottom_rank_button_layout);
        releaseButtonView = (LinearLayout)this.findViewById(R.id.main_activity_bottom_release_button_layout);
        paikeButtonView = (LinearLayout)this.findViewById(R.id.main_activity_bottom_paike_button_layout);
        myButtonView = (LinearLayout)this.findViewById(R.id.main_activity_bottom_my_button_layout);
        fragmentContainer = (MyViewPage) this.findViewById(R.id.main_activity_fragment_container);

        homeBottomImage = (ImageView)this.findViewById(R.id.main_activity_bottom_home_button_image);
        rankBottomImage = (ImageView)this.findViewById(R.id.main_activity_rank_home_button_image);
        releaseBottomImage = (ImageView)this.findViewById(R.id.main_activity_bottom_release_button_image);
        paikeBottomImage = (ImageView)this.findViewById(R.id.main_activity_bottom_paike_button_image);
        myBottomImage = (ImageView)this.findViewById(R.id.main_activity_bottom_my_button_image);

        homeBottomText = (TextView)this.findViewById(R.id.main_activity_bottom_home_button_text);
        rankBottomText = (TextView)this.findViewById(R.id.main_activity_bottom_rank_button_text);
        releaseBottomText = (TextView)this.findViewById(R.id.main_activity_bottom_release_button_text);
        paikeBottomText = (TextView)this.findViewById(R.id.main_activity_bottom_paike_button_text);
        myBottomText = (TextView)this.findViewById(R.id.main_activity_bottom_my_button_text);

        setOnViewListener();
    }

    private void setOnViewListener() {
        homeButtonView.setOnClickListener(this);
        rankButtonView.setOnClickListener(this);
        releaseButtonView.setOnClickListener(this);
        paikeButtonView.setOnClickListener(this);
        myButtonView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_activity_bottom_home_button_layout:
                showFragmentById(FRAGMENT_INDEX_00);
                break;
            case R.id.main_activity_bottom_rank_button_layout:
                showFragmentById(FRAGMENT_INDEX_01);
                break;
            case R.id.main_activity_bottom_release_button_layout:
                showFragmentById(FRAGMENT_INDEX_02);
                break;
            case R.id.main_activity_bottom_paike_button_layout:
                showFragmentById(FRAGMENT_INDEX_03);
                break;
            case R.id.main_activity_bottom_my_button_layout:
                showFragmentById(FRAGMENT_INDEX_04);
                break;
        }
    }

    private void showFragmentById(int fragmentId) {
        if(nowShowFragment == null){
            fragmentContainer.setCurrentItem(fragmentId);
            bottomTextList.get(fragmentId).setTextColor(this.getResources().getColor(R.color.main_bottombar_buttontext_selected_color));
            nowShowFragment = fragmentList.get(fragmentId);
        }else if(fragmentId == nowShowFragment.getFragmentId()){
            return;
        }else{
            fragmentContainer.setCurrentItem(fragmentId);
            bottomTextList.get(fragmentId).setTextColor(this.getResources().getColor(R.color.main_bottombar_buttontext_selected_color));
            bottomTextList.get(nowShowFragment.getFragmentId()).
                    setTextColor(this.getResources().getColor(
                            R.color.main_bottombar_buttontext_normal_color));
            nowShowFragment = fragmentList.get(fragmentId);
        }
    }
}
