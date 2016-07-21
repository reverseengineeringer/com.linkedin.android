package com.linkedin.android.infra.shared;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.home.launcher.AppInfo;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.pegasus.gen.voyager.common.LaunchAlert;
import javax.inject.Inject;

public final class AppUpgradeUtils
{
  private final FlagshipSharedPreferences sharedPreferences;
  
  @Inject
  public AppUpgradeUtils(FlagshipSharedPreferences paramFlagshipSharedPreferences)
  {
    sharedPreferences = paramFlagshipSharedPreferences;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.shared.AppUpgradeUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */