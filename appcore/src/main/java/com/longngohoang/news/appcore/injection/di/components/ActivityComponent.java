
package com.longngohoang.news.appcore.injection.di.components;

import android.app.Activity;

import com.longngohoang.news.appcore.injection.di.PerActivity;
import com.longngohoang.news.appcore.injection.di.modules.ActivityModule;

import dagger.Component;


@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
  //Exposed to sub-graphs.
  Activity activity();
}
