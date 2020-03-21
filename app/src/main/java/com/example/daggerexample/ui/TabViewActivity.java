package com.example.daggerexample.ui;

import android.graphics.Color;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.viewpager.widget.ViewPager;

import com.example.daggerexample.BaseActivity;
import com.example.daggerexample.R;
import com.google.android.material.tabs.TabLayout;

public class TabViewActivity extends BaseActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ViewFlipper viewFlipper;
    private ViewPagerAdapter adapter;
    private CallFragment callFragment;
    private LogsFragment logsFragment;
    private RecentFragments recentFragments;

    @Override
    public int getLayoutResource() {
        return R.layout.activity_tab_view;
    }

    @Override
    protected void initViews() {

        callFragment = new CallFragment();
        logsFragment = new LogsFragment();
        recentFragments = new RecentFragments();

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        viewFlipper = findViewById(R.id.imageViewFlipper);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragmentAndTitles(new CallFragment(), "Call");
        adapter.addFragmentAndTitles(new RecentFragments(), "Recent");
        adapter.addFragmentAndTitles(new LogsFragment(), "Logs");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.white));

        int position = getIntent().getIntExtra("Position", -1);
        if(position != -1){

            setUpAnInitialImageInViewFlipper(position);
            tabLayout.getTabAt(position).select();
        }



        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            ImageView imageView = new ImageView(TabViewActivity.this);

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case 0:
                        if (imageView == null) {
                            imageView.setImageResource(R.drawable.image_1);
                            viewFlipper.addView(imageView);


                        } else {
                            viewFlipper.removeAllViews();
                            imageView.setImageResource(R.drawable.image_1);
                            viewFlipper.addView(imageView);
                        }
                        break;

                    case 1:
                        if (imageView == null) {

                            imageView.setImageResource(R.drawable.image_4);
                            viewFlipper.addView(imageView);

                        } else {
                            viewFlipper.removeAllViews();
                            imageView.setImageResource(R.drawable.image_4);
                            viewFlipper.addView(imageView);

                        }
                        break;

                    case 2:
                        if (imageView == null) {

                            imageView.setImageResource(R.drawable.image_3);
                            viewFlipper.addView(imageView);
                        } else {

                            viewFlipper.removeAllViews();
                            imageView.setImageResource(R.drawable.image_3);
                            viewFlipper.addView(imageView);


                        }
                        break;
                }

                Animation animationIn = AnimationUtils.loadAnimation(TabViewActivity.this, android.R.anim.slide_in_left);
                Animation animationOut = AnimationUtils.loadAnimation(TabViewActivity.this, android.R.anim.slide_out_right);

                viewFlipper.setInAnimation(animationIn);
                viewFlipper.setOutAnimation(animationOut);
                }

                @Override
                public void onPageScrollStateChanged ( int state){

                }
            });


        }

        public void setUpAnInitialImageInViewFlipper(int position){
            ImageView imageView = new ImageView(TabViewActivity.this);
            switch (position){
                case 0:
                    imageView.setImageResource(R.drawable.image_1);
                    break;

                case 1:
                    imageView.setImageResource(R.drawable.image_4);
                    break;

                case 2:
                    imageView.setImageResource(R.drawable.image_3);
                    break;

            }
            viewFlipper.addView(imageView);


        }
        @Override
        protected void handlerClicks () {


        }
    }
