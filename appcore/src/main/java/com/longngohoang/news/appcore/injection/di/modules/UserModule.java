
package com.longngohoang.news.appcore.injection.di.modules;


import com.longngohoang.news.appcore.injection.di.PerActivity;
import com.longngohoang.news.appcore.interactor.UseCase;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {

  private int userId = -1;

  public UserModule() {}

  public UserModule(int userId) {
    this.userId = userId;
  }

  @Provides
  @PerActivity
  @Named("userList") UseCase provideGetUserListUseCase(
      GetUserList getUserList) {
    return getUserList;
  }

  @Provides
  @PerActivity @Named("userDetails")
  UseCase provideGetUserDetailsUseCase(
      UserRepository userRepository, ThreadExecutor threadExecutor,
      PostExecutionThread postExecutionThread) {
    return new GetUserDetails(userId, userRepository, threadExecutor, postExecutionThread);
  }
}