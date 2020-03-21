package com.example.daggerexample.di.module;

import android.app.Application;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.example.daggerexample.R;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {


    @Singleton
    @Provides
    static RequestOptions provideRequestOption(){
        return RequestOptions.placeholderOf(R.drawable.ic_add_black_24dp)
                .error(R.drawable.ic_add_black_24dp);
    }

    @Singleton
    @Provides
    static RequestManager provideGlideInstance(Application application, RequestOptions requestOptions){
        return Glide.with(application).setDefaultRequestOptions(requestOptions);
    }

    @Singleton
    @Provides
    static String previousName(){
        return "Jaspreet Singh";
    }
}
