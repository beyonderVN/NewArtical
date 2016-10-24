
package com.longngohoang.news.appcore.injection.di.components;

import com.longngohoang.news.appcore.injection.di.PerActivity;
import com.longngohoang.news.appcore.injection.di.modules.ActivityModule;
import com.longngohoang.news.appcore.injection.di.modules.UserModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, UserModule.class})
public interface UserComponent extends ActivityComponent {
  void inject(UserListFragment userListFragment);
  void inject(UserDetailsFragment userDetailsFragment);
}
