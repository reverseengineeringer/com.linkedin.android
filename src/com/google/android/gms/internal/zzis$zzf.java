package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.webkit.WebSettings;

@TargetApi(16)
public class zzis$zzf
  extends zzis.zzc
{
  public final void zza(ViewTreeObserver paramViewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    paramViewTreeObserver.removeOnGlobalLayoutListener(paramOnGlobalLayoutListener);
  }
  
  public boolean zza(Context paramContext, WebSettings paramWebSettings)
  {
    super.zza(paramContext, paramWebSettings);
    paramWebSettings.setAllowFileAccessFromFileURLs(false);
    paramWebSettings.setAllowUniversalAccessFromFileURLs(false);
    return true;
  }
  
  public final void zzb(Activity paramActivity, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    paramActivity = paramActivity.getWindow();
    if ((paramActivity != null) && (paramActivity.getDecorView() != null) && (paramActivity.getDecorView().getViewTreeObserver() != null)) {
      paramActivity.getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(paramOnGlobalLayoutListener);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzis.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */