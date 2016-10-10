package com.longngo.moviebox.common.di;

import android.content.Context;

import com.longngo.moviebox.data.backend.MovieBoxService;

import com.longngo.moviebox.data.backend.MovieBoxServiceApi;
import com.longngo.moviebox.data.source.MoviesRepository;
import com.longngo.moviebox.ui.activity.main.MainActivity;
import com.longngo.moviebox.common.schedulers.BaseSchedulerProvider;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Long on 7/8/2016.
 */
@Singleton
@Component(modules = {MainModule.class})
public interface MainComponent {
    Context context();
    MovieBoxService dataManager();
    BaseSchedulerProvider schedulerProvider() ;
    void inject(MainActivity mainActivity);




}
