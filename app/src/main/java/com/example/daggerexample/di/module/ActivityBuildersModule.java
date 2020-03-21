package com.example.daggerexample.di.module;

import com.example.daggerexample.ui.GridListActivity;
import com.example.daggerexample.ui.LoginActivity;
import com.example.daggerexample.ui.SplashActivity;
import com.example.daggerexample.ui.TabViewActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract LoginActivity contributesLoginActivity();

    @ContributesAndroidInjector
    abstract SplashActivity contributesSplashActivity();

    @ContributesAndroidInjector
    abstract TabViewActivity contributesTabViewActivity();


    @ContributesAndroidInjector
    abstract GridListActivity contributesGridListActivity();


}
