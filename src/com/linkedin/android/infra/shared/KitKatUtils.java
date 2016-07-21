package com.linkedin.android.infra.shared;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import com.linkedin.android.logger.Log;

public class KitKatUtils
{
  private static final String TAG = KitKatUtils.class.getSimpleName();
  
  public static void bringToFront(View paramView)
  {
    paramView.bringToFront();
    if (Build.VERSION.SDK_INT < 19)
    {
      paramView = paramView.getParent();
      if (paramView != null) {
        paramView.requestLayout();
      }
    }
  }
  
  @TargetApi(19)
  public static boolean isLocationDisabled(ContentResolver paramContentResolver)
  {
    boolean bool = false;
    if (Build.VERSION.SDK_INT >= 19) {
      try
      {
        int i = Settings.Secure.getInt(paramContentResolver, "location_mode");
        if (i == 0) {
          bool = true;
        }
        return bool;
      }
      catch (Settings.SettingNotFoundException paramContentResolver)
      {
        Log.wtf(TAG, "Error getting location mode setting; this should never happen", paramContentResolver);
        return false;
      }
    }
    return TextUtils.isEmpty(Settings.Secure.getString(paramContentResolver, "location_providers_allowed"));
  }
  
  public static boolean isRunningAndNotPaused(Animator paramAnimator)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return (paramAnimator.isRunning()) && (!paramAnimator.isPaused());
    }
    return paramAnimator.isRunning();
  }
  
  public static void pauseOrCancel(Animator paramAnimator)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramAnimator.pause();
      return;
    }
    paramAnimator.cancel();
  }
  
  public static void resumeOrStart(Animator paramAnimator)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      if (paramAnimator.isPaused())
      {
        paramAnimator.resume();
        return;
      }
      paramAnimator.start();
      return;
    }
    paramAnimator.start();
  }
  
  public static void setPluginState(WebView paramWebView)
  {
    if (Build.VERSION.SDK_INT < 19)
    {
      paramWebView = paramWebView.getSettings();
      if (paramWebView != null) {
        paramWebView.setPluginState(WebSettings.PluginState.ON_DEMAND);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.shared.KitKatUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */