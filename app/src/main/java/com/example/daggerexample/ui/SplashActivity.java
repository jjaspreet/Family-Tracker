package com.example.daggerexample.ui;

import android.content.Intent;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daggerexample.BaseActivity;
import com.example.daggerexample.R;


public class SplashActivity extends BaseActivity {

    Animation topAnimation, bottomAnimation;
    ImageView imageView;
    TextView splashTextView;
    Handler handler;

    @Override
    public int getLayoutResource() {
        return R.layout.activity_splash_screen;
    }

    @Override
    protected void initViews() {


    topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_anim);
    bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

    imageView = findViewById(R.id.trackerImageView);

    splashTextView = findViewById(R.id.splashTextView);

    imageView.setAnimation(topAnimation);
    splashTextView.setAnimation(bottomAnimation);

    }

    @Override
    protected void handlerClicks() {

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2500);

    }
}
