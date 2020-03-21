package com.example.daggerexample.di.component;

import android.app.Application;

import com.example.daggerexample.BaseApplication;
import com.example.daggerexample.di.module.ActivityBuildersModule;
import com.example.daggerexample.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                ActivityBuildersModule.class,
                AppModule.class
        }

)
public interface AppComponent extends AndroidInjector<BaseApplication> {


    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
