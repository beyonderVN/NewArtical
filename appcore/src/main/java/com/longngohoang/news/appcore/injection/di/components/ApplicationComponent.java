
package com.longngohoang.news.appcore.injection.di.components;

import android.content.Context;

import com.longngohoang.news.appcore.common.schedulers.SchedulerProvider;
import com.longngohoang.news.appcore.injection.di.modules.ApplicationModule;
import com.longngohoang.news.appcore.interactor.ArticleRepository;
import com.longngohoang.news.appcore.presentation2.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;


@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
  void inject(BaseActivity baseActivity);

  //Exposed to sub-graphs.
  Context context();
  SchedulerProvider schedulerProvider();
  ArticleRepository articleRepository();
}
