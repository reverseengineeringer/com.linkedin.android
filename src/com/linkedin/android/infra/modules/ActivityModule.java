package com.linkedin.android.infra.modules;

import android.content.ContentResolver;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import com.linkedin.android.ConfirmEmailAddress.DeepLinkEmailManagementController;
import com.linkedin.android.ConfirmEmailAddress.EmailManagementController;
import com.linkedin.android.growth.lego.LegoManager;
import com.linkedin.android.growth.login.smartlock.SmartLockManager;
import com.linkedin.android.growth.login.sso.SSOManager;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.shared.Util;
import dagger.Module;
import dagger.Provides;

@Module
public final class ActivityModule
{
  private BaseActivity activity;
  
  public ActivityModule(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity == null) {
      Util.safeThrow(new IllegalArgumentException("BaseActivity cannot be null"));
    }
    activity = paramBaseActivity;
  }
  
  @Provides
  public final BaseActivity baseActivity()
  {
    return activity;
  }
  
  @Provides
  public final ContentResolver contentResolver()
  {
    return activity.getContentResolver();
  }
  
  @Provides
  public final DeepLinkEmailManagementController deepLinkEmailManagementController()
  {
    return new DeepLinkEmailManagementController(activity.activityComponent.networkClient(), activity);
  }
  
  @Provides
  public final EmailManagementController emailManagementController()
  {
    return new EmailManagementController(activity.activityComponent.networkClient(), activity);
  }
  
  @Provides
  public final LayoutInflater layoutInflater()
  {
    return activity.getLayoutInflater();
  }
  
  @Provides
  public final LegoManager legoManager()
  {
    return new LegoManager(activity.activityComponent.onboardingDataProvider());
  }
  
  @Provides
  public final Context provideContext()
  {
    return activity;
  }
  
  @Provides
  public final SmartLockManager smartLockManager()
  {
    return new SmartLockManager(activity);
  }
  
  @Provides
  public final SSOManager ssoManager(FlagshipSharedPreferences paramFlagshipSharedPreferences)
  {
    return new SSOManager(activity, paramFlagshipSharedPreferences, activity.activityComponent.loginUtils());
  }
  
  @Provides
  public final FragmentManager supportFragmentManager()
  {
    return activity.getSupportFragmentManager();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.modules.ActivityModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */