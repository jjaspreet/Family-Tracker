package com.example.daggerexample.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;
import com.example.daggerexample.BaseActivity;
import com.example.daggerexample.R;

import org.w3c.dom.Text;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class LoginActivity extends BaseActivity {

    private static final String TAG = "LoginActivity";
    private Toolbar toolbar;
    private Button button, moveToNextButton;
    private TextView nameTextView;
    private ImageView imageView;

    @Inject
    String name;

    @Inject
    RequestManager glideInstance;



    @Override
    public int getLayoutResource() {
        return R.layout.activity_login;
    }

    @Override
    protected void initViews() {

        toolbar = findViewById(R.id.toolbar);
        button = findViewById(R.id.showLoaderbutton);
        moveToNextButton = findViewById(R.id.moveToNextButton);
        nameTextView = findViewById(R.id.nameTextView);
        imageView = findViewById(R.id.imageView);


        initToolBar();

        Log.d(TAG, "onCreate: " + name);

        nameTextView.setText(name);

        setImageIntoView();

    }

    private void setImageIntoView() {
        glideInstance.load(R.drawable.ic_android_black_24dp)
                .into(imageView);
    }

    @Override
    protected void handlerClicks() {

        moveToNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, GridListActivity.class));
            }
        });

        showLoader();
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                showLoader();
                ThreadHandler threadHandler = new ThreadHandler();

                new Thread(threadHandler).start();
            }
        });



        ThreadHandler threadHandler = new ThreadHandler();

        new Thread(threadHandler).start();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void initToolBar() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setVisibility(View.VISIBLE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
    }

    class ThreadHandler implements Runnable{

        @Override
        public void run() {
            Handler handler = new Handler(Looper.getMainLooper());

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    hideLoader();
                }
            }, 1000);
        }
    }

}
