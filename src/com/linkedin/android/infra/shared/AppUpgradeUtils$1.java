package com.linkedin.android.infra.shared;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.home.launcher.AppInfo;
import com.linkedin.android.pegasus.gen.voyager.common.LaunchAlert;

public final class AppUpgradeUtils$1
  implements View.OnClickListener
{
  public AppUpgradeUtils$1(AppUpgradeUtils paramAppUpgradeUtils, Activity paramActivity, LaunchAlert paramLaunchAlert) {}
  
  public final void onClick(View paramView)
  {
    Uri localUri = AppInfo.getAppStoreLink(val$activity.getPackageName(), null);
    paramView = localUri;
    if (localUri == null) {
      if (val$launchAlert.link == null) {
        break label63;
      }
    }
    label63:
    for (paramView = Uri.parse(val$launchAlert.link); paramView != null; paramView = null)
    {
      paramView = new Intent("android.intent.action.VIEW", paramView);
      val$activity.startActivity(paramView);
      return;
    }
    System.exit(0);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.shared.AppUpgradeUtils.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */