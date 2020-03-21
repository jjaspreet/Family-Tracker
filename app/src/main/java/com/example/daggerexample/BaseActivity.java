package com.example.daggerexample;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;

import dagger.android.support.DaggerAppCompatActivity;


public abstract class BaseActivity extends DaggerAppCompatActivity {

    private Dialog progreeDialog;
    private ViewStub viewStub;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        viewStub = findViewById(R.id.viewStub);

        viewStub.setLayoutResource(getLayoutResource());

        viewStub.inflate();

        initViews();
        initProgressDialog();
        handlerClicks();


    }

    @LayoutRes
    public abstract int getLayoutResource();


    protected abstract void initViews();


    protected abstract void handlerClicks();


    private void initProgressDialog() {

        progreeDialog = new Dialog(this);
        progreeDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = this.getLayoutInflater().inflate(R.layout.gif_loader_layout, null);
        progreeDialog.setContentView(view);
        progreeDialog.setCancelable(false);
        progreeDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
    }

    public void showLoader() {
        progreeDialog.show();
    }

    public void hideLoader() {
        if (progreeDialog != null) {
            progreeDialog.dismiss();
        }
    }

}
