package com.linkedin.android.growth.login;

import android.content.Context;
import com.linkedin.android.appwidget.AppWidgetUtils;
import com.linkedin.android.authenticator.AccountChangeReceiver;
import com.linkedin.android.growth.contactsync.ContactSyncAdapter;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.app.LaunchUtils;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.l2m.notification.PackageReplacedReceiver;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;

public final class LoginUtils
{
  private final Auth auth;
  private final LaunchUtils launchUtils;
  private final LixManager lixManager;
  
  @Inject
  public LoginUtils(LaunchUtils paramLaunchUtils, LixManager paramLixManager, Auth paramAuth)
  {
    launchUtils = paramLaunchUtils;
    lixManager = paramLixManager;
    auth = paramAuth;
  }
  
  public final void onSignin(Context paramContext)
  {
    launchUtils.onAuthenticatedAppProcessStarted(paramContext, lixManager, true);
    ContactSyncAdapter.addLinkedInAccount(paramContext, lixManager, auth);
    AppWidgetUtils.handleSignin(paramContext);
    Util.setComponentEnabled(paramContext, PackageReplacedReceiver.class, true);
    Util.setComponentEnabled(paramContext, AccountChangeReceiver.class, true);
    if (!FlagshipApplication.IS_BACKGROUND.get()) {
      launchUtils.onAppEnteredForeground((FlagshipApplication)paramContext.getApplicationContext(), true, true);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.LoginUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */